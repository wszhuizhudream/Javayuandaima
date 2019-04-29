<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/27
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<form action="/user/login" method="post">
    <label for="username">用户名：</label><input id="username" type="text" name="username" placeholder="请输入用户名">
    <label for="password">密码：</label><input id="password" type="text" name="password"  placeholder="请输入用户名">
    <input type="submit" value="登陆">
</form>
</body>
</html>
