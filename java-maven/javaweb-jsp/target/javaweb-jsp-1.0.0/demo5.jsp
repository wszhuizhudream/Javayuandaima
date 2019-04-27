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
    <title>out对象</title>
</head>
<body>    
<h1>用户登录</h1>    
<hr>    
<form action="/doLogin" name="loginForm" method="get">        
    <table>            
        <tr>                
            <td>用户名：</td>                
            <td><input type="text" name="userName"></td>            
        </tr>            
        <tr>                
            <td>密码：</td>                
            <td><input type="password" name="password"></td>            
        </tr>

         <tr>                
            <td>掌握语言：</td>                
            <td>                    
                <input type="checkbox" name="skill" value="C语言">C语言                    
                <input type="checkbox" name="skill" value="Java">Java                    
                <input type="checkbox" name="skill" value="C++">C++                    
                <input type="checkbox" name="skill" value="Python">Python                
            </td>            
        </tr>  

                 
        <tr>              
            <td colspan="2"><input type="submit" value="登录"></td>            
        </tr>        
    </table>    
</form>
</body>
</html>
