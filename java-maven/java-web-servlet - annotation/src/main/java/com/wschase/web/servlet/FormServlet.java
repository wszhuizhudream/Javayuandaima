package com.wschase.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:WSChase
 * Created:2019/4/25
 */
public class FormServlet extends HttpServlet {


    //表单视图-实现servlet
    //注意：doGet是用来提交数据的
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //这个相当于是客户端输出
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<form method='POST' action='/form'>")
                .append("请输出姓名：")
                .append("<input name='name' type='text' value=''/>")
                .append("<input type='submit' value='提交>")
                .append("</form>")
                .append("</body>")
                .append("</html>");
    }

    //提交表单处理

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        resp.setContentType("text/html; charset=UTF-8");
        //服务端响应：相当于是服务端输出
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("欢迎，")
                .append(name)
                .append("</h1>")
                .append("</body>")
                .append("</html>");
    }
}
