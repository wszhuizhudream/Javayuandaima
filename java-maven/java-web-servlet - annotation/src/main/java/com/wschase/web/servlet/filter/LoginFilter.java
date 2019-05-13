package com.wschase.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**非常常用
 * Author:WSChase
 * Created:2019/4/25
 */
@WebFilter(filterName="LoginFilter",urlPatterns={"/*"},initParams = {
        //初始化参数
        @WebInitParam(name="execlude",value="/login,/index,/")
})
public class LoginFilter implements Filter {
    private String[] urlArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls=filterConfig.getInitParameter("exclude");
        if(urls==null||urls.length()==0){
            urlArray=new String[]{};
        }else {
            urlArray=urls.split(",");
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;

        String uri=req.getRequestURI();
        boolean exclude=false;
        for(String item:urlArray){
            if(item.equals(uri)){
                exclude=true;
                break;
            }
        }

        if(exclude){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session=req.getSession();
        Object attributeValue=session.getAttribute("current_user");
        if(attributeValue==null){
            writer.append("<a href='/login'>").append("还未登陆，请登陆").append("</a>");
        }else {
           filterChain.doFilter(servletRequest,servletResponse);
        }
        }
    }

    @Override
    public void destroy() {

    }
}
