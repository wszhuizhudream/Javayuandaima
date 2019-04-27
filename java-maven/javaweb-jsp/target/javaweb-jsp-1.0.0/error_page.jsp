<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isErrorPage="true" %>
<html>
<head>
    <title>服务内部错误</title>
</head>
<body>
<h1>服务在暂时不可用，发生异常信息如下：</h1>
    异常消息为:<%=exception.getMessage()%>
</body>
</html>
