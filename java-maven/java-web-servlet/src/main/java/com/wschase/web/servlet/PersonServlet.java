package com.wschase.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:WSChase
 * Created:2019/4/25
 */
public class PersonServlet extends HiddenServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Person person=personMap.get(id);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        //请求地址的时候可能没有传id
        if(id==null){
            writer.append("参数不能为空");
        }

        //我们隐藏编号
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>修改人员信息</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/person\">\n" +
                "    <input type=\"text\" name=\"id\" hidden=\"hidden\" value=\""+person.getId()+"\"/>\n" +
                "    姓名：<input type=\"text\" name=\"name\" value=\""+person.getName()+"\" placeholder=\"请输入姓名\">\n" +
                "    年龄：<input type=\"text\" name=\"age\" value=\""+person.getAge()+"\" placeholder=\"请输入年龄\">\n" +
                "    <input type=\"submit\" value=\"保存更新\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

        //给个页面

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();
        String id=req.getParameter("id");
        if(id==null){
            //则认为是新建用户
            writer.write("暂时不支持");

        }else {
            //修改用户
            String name=req.getParameter("name");
            String ageStr=req.getParameter("age");
            Person person=personMap.get(id);
            person.setAge(Integer.parseInt(ageStr));
            person.setName(name);
           writer.append("<a href='/hidden'>").append("回到列表").append("</a>");

        }
    }
}
