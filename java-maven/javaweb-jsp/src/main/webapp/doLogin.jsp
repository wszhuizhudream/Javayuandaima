<%--
  Created by IntelliJ IDEA.
  User: 王偲
  Date: 2019/4/26
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out对象</title>
</head>
<body>    
<h1>用户登录</h1>    
<h1>用户名：<%=request.getParameter("userName")%>
</h1>   
<h1>密码：<%=request.getParameter("password")%>
</h1> 

<ul>
    技能：
    <%
        //要用Java语言处理逻辑，那么我们就写一个脚本的括号然后进行编写java代码，这样就方便了很多
        String[] skill=request.getParameterValues("skill");
        for(int i=0;i<skill.length;i++){
            out.println("<li>"+skill[i]+"</li>");
        }
    %>
</ul>
         

</form>
</body>
</html>
