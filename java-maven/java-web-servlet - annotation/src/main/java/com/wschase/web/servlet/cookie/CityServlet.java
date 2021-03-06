package com.wschase.web.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:WSChase
 * Created:2019/4/25
 */
public class CityServlet extends HttpServlet {
    private Map<String,List<String>> proCity=new HashMap<>();

    private Map<String,List<String>> cityDist= new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        List<String> citys=new ArrayList<>();
        citys.add("西安");
        citys.add("宝鸡");
        citys.add("咸阳");

        proCity.put("陕西",citys);

        List<String> xianDist=new ArrayList<>();
        xianDist.add("雁塔区");
        xianDist.add("临潼区");
        xianDist.add("未央区");
        cityDist.put("西安",xianDist);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pro=req.getParameter("pro");
        //取Cookie
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("pro")){
                    pro=cookie.getName();
                    break;
                }
            }
        }

        String city=req.getParameter("city");
        //省
        if(pro!=null&&city==null){
            //处理省
            List<String> citys=proCity.get(pro);

            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>市</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<table>\n" +
                    "    <thead>\n" +
                    "    <tr>\n" +
                    "        <td>编号</td>\n" +
                    "        <td>市</td>\n" +
                    "    </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>");
            int id = 1;
            for (String c:citys) {
                writer.append("<tr>")
                        .append("<td>").append(String.valueOf(id)).append("</td>")
                        .append("<td>")
                        .append("<a href='").append("/url?pro=").append(pro).append("&city=")
                        .append(c).append("'>")
                        .append(c)
                        .append("</a>")
                        .append("</td>")
                        .append("</tr>");
                id = id + 1;
            }
            writer.append("    </tbody>\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "</html>");


        } else if(pro!=null&&city!=null){
            //市
            List<String> dist=cityDist.get(city);
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>区</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<table>\n" +
                    "    <thead>\n" +
                    "    <tr>\n" +
                    "        <td>编号</td>\n" +
                    "        <td>区</td>\n" +
                    "    </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>");
            int id = 1;
            for (String d:dist) {
                writer.append("<tr>")
                        .append("<td>").append(String.valueOf(id)).append("</td>")
                        .append("<td>")
                        .append("<a href='").append("/city?").append("&city=")
                        .append(d).append("'>")
                        .append(d)
                        .append("</a>")
                        .append("</td>")
                        .append("</tr>");
                id = id + 1;
            }
            writer.append("    </tbody>\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "</html>");
        }else {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.append("No data");
        }

    }
}
