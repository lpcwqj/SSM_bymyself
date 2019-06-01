<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/30
  Time: 9:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<%--<script src="../js/jquery-2.1.0.js"></script>--%>
<body>
<form id="form1" name="form1" action="/update?id=${user.id}" method="post">
    <table border="2" width="50%">
        <tr>
            <td>id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>username</td>
            <td><input type="text" name="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input type="text" name="phone" value="${user.phone}"/></td>
        </tr>
        <tr>
            <td>rolename</td>
            <td><input type="text" name="rolename" value="${user.rolename}"/><br></td>
        </tr>
        <tr>
            <td colspan="1"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
