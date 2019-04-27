<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向和转发</title>
</head>
<body>    
<h1>重定向和转发</h1>    
<hr>    
<%
//    //（1）重定向:这个时候访问demo7.jsp的时候直接重定向到demo5.jsp——这个是客户端的行为是两次请求
//    response.sendRedirect("demo5.jsp");

    //（2）转发:服务端内部处理——是服务端行为,是服务端的行为，一次请求
    request.getRequestDispatcher("demo5.jsp").forward(request,response);
%>
     

</body>
</html>
