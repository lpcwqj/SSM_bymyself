<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/30
  Time: 14:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<form id="form1" name="form1" action="/add" method="post">
    <table border="2" width="50%">
        <tr>
            <td>username</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input type="text" name="phone" /></td>
        </tr>
        <tr>
            <td>rolename</td>
            <td><input type="text" name="rolename" /><br></td>
        </tr>
        <tr>
            <td colspan="1"></td>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
