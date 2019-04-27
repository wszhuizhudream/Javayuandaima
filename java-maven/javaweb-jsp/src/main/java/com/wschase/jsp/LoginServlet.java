package com.wschase.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Author:WSChase
 * Created:2019/4/26
 */
@WebServlet(name="LoginServlet",urlPatterns ="/doLogin" )
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("userName");
        String password=req.getParameter("password");
        String[] skill=req.getParameterValues("skill");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.append("UserName=").append(name).append("</br>")
                .append("Password=").append(password).append(Arrays.toString(skill));
    }
}
