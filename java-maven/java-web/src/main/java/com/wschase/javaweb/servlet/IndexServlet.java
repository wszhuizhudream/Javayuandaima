package com.wschase.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**这个是一个动态程序
 * Author:WSChase
 * Created:2019/4/24+
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("Hello Java Web Power by Servlet")
                .append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .append("</h1>")
                .append("</body>");
    }
}
