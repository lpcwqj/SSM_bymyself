<%--
  Author: Lin
  Date: 2019/6/1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/login" method="post">
    <table border="2">
    <tr>
        <td>username:</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>password:</td>
        <td><input type="text" name="password"></td>
    </tr>
    <tr>
        <td colspan="1"></td>
        <td><input type="submit" value="submit">
            <input type="reset" value="reset">
        </td>
    </tr>
    </table>
</form>

<b style="color: red;font-size: 50px">${msg}</b>

</body>
</html>
