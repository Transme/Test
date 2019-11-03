<%--
  Created by IntelliJ IDEA.
  User: 15058
  Date: 2019/10/24
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h1 align="center">登录</h1>
<hr>
<form action="DemoServlet" method="post">
    <table align="center">
        <tr>
            <td><b>用户名：</b></td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><b>密码</b></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
