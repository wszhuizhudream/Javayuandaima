<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--你好-->
<h1>欢迎</h1>
<h3>
    <%--jsp注释--%>
    <%
        //获取当前时间
        String dateTime=new Date().toString();
    %>
    <%=dateTime%>
</h3>
</body>
</html>
