<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext内置对象</title>
</head>
<body>
<h1>pageContext内置对象</h1>
<%
    session.setAttribute("username","admin");
%>
<%=pageContext.getSession().getAttribute("username")%>
</br>
<%
    //pageContext.include("page_include.isp");
    pageContext.forward("demo5.jsp");
%>

</body>
</html>
