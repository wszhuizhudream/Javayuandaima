package com.wschase.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**过滤器的实现
 * Author:WSChase
 * Created:2019/4/25
 */
public class LogFilter implements Filter {
    //前缀
    private String prefix;

    private PrintWriter writer;
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix=filterConfig.getInitParameter("prefix");

        String filename=filterConfig.getInitParameter("logFileName");
        //获取程序的目录：web应用的根目录
        String logPath=filterConfig.getServletContext().getRealPath("/log");
        File logFile=new File(logPath,filename);
        if(!logFile.getParentFile().exists()){
            logFile.getParentFile().mkdirs();
        }

        try {
            writer=new PrintWriter(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(writer==null){
            throw new RuntimeException("PrintWriter 不能为空");
        }
    }

    /**
     * 过滤
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest) servletRequest;
        String uri=req.getRequestURI();

        String log=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                +"--"+this.prefix+"--"+uri+"\n";
            writer.write(log);
            writer.flush();

            //拦截器继续往下走
        filterChain.doFilter(servletRequest,servletResponse);


    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        if(writer!=null){

        writer.close();
        }

    }
}
