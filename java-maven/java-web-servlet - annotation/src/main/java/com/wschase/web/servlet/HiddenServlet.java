package com.wschase.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:WSChase
 * Created:2019/4/25
 */
public class HiddenServlet extends HttpServlet {
    protected static Map<String,Person> personMap=new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();

        Person java=new Person("1001","java",20);
        Person php=new Person("1002","php",10);
        Person c=new Person("1003","c",30);

        personMap.put("1001",java);
        personMap.put("1002",php);
        personMap.put("1003",c);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>用户信息</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>用户信息列表</h1>\n" +
                "<table>\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <td>编号</td>\n" +
                "        <td>姓名</td>\n" +
                "        <td>年龄</td>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>");

        int i=1;
        for(Map.Entry<String,Person> entry:personMap.entrySet()){
            Person person=entry.getValue();
            writer.append("<tr>")
                    .append("<td>")
                    .append("<a href='/person?id=").append(person.id).append("'>")
                    .append(String.valueOf(person.id))
                    .append("</a>")
                    .append("</td>")
                    .append("<td>").append(person.name).append("</td>")
                    .append("<td>").append(String.valueOf(person.age)).append("</td>")
                    .append("</tr>");
        }

        writer.append(" </tbody>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");

    }

    public static class Person{
        private String id;
        private String name;
        private int age;

        public Person(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
