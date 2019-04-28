package com.wschase.web.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**登陆
 * Author:WSChase
 * Created:2019/4/25
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>用户登陆页面</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/login\">\n" +
                "    <label for=\"username\">用户名</label><input id=\"username\" name=\"username\" value=\"\" type=\"text\" placeholder=\"请输入用户名\">\n" +
                "    <label for=\"password\">用户名</label><input id=\"password\" name=\"password\" value=\"\" type=\"password\" placeholder=\"请输入用户密码\">\n" +
                "    <input type=\"submit\" value=\"登陆\">\n" +
                "</form>\n" +
                "   \n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
    }

    //处理登陆
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //如果要往前端写东西就需要这两句话
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        if("admin".equals(username)&&"admin123".equals(password)){
            HttpSession session=req.getSession();
            session.setAttribute("current_user",username);
            writer.append("登陆成功").append("<a href='/form'>").append("欢迎").append("</a>");
        }else {
            writer.append("<a href='/login'>").append("登陆失败，返回").append("</a>");
        }
    }
}
