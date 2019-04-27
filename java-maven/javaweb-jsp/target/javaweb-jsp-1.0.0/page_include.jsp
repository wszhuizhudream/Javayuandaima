<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page内置对象</title>
</head>
<body>
<h1>page对象</h1>
<hr>

<%application.setAttribute("city","Xi'An");
application.setAttribute("Company","Bitekeji");
application.setAttribute("postmain",710000);
%>  
所在城市为:<%=application.getAttribute("city")%><br>
 
application中的属性有:  
<%
    Enumeration<String> enumeration = application.getAttributeNames();
    while (enumeration.hasMoreElements()) {
        out.println(enumeration.nextElement()+"&nbsp;&nbsp;");
    }
    %>
<br>  
JSP(Servlet)引擎名与版本号：<%=application.getServerInfo()%>
<br>
</body>
</html>
