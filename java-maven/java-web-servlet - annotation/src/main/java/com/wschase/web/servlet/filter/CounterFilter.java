package com.wschase.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**过滤器的应用场景2
 * Author:WSChase
 * Created:2019/4/25
 */
public class CounterFilter implements Filter {
    //创建线程：通过调用线程池
    private ExecutorService executor= Executors.newSingleThreadExecutor();

    private Properties properties;

    private File countFile;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filename=filterConfig.getInitParameter("countFileName");
        String logPath=filterConfig.getServletContext().getRealPath("/log");
        countFile=new File(logPath,filename);
        if(!countFile.getParentFile().exists()){
            countFile.getParentFile().mkdirs();
        }
        if(!countFile.exists()){
            try {
                countFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        properties=new Properties();
        try {

            //把文件内容加到properties
            properties.load(new FileInputStream(countFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req= (HttpServletRequest) servletRequest;
       final String url=req.getRequestURI();
       //异步处理URL的请求统计
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                    Object value= properties.get(url);
                    if(value==null){
                        value="1";
                    }else {
                        value=Integer.parseInt((String) value)+1 ;
                    }
                    properties.put(url,String.valueOf(value));
                        try {
                            //读一次操作存一次
                            properties.store(new FileOutputStream(countFile),"");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {


    }
}
