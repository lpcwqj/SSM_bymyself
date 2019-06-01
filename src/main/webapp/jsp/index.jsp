<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/29
  Time: 10:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>分页</title>
</head>
<body>
<form id="form0" name="form1" method="post" action="/vagueQuery">
    id: <input type="text" name="id">&nbsp;&nbsp;
    用户名: <input type="text" name="username">&nbsp;&nbsp;
    <input type="submit" value="筛选">
    <button><a href="../jsp/add.jsp">添加用户</a></button>
</form>

<form id="form1" name="form1" method="post" action="/batchDeletion">
    <table border="2" width="100%">
        <thead>
        <tr align="center">
            <td><input type="checkbox" name="ids"></td>
            <td>userName</td>
            <td>password</td>
            <td>email</td>
            <td>phone</td>
            <td>roleName</td>
            <td colspan="2">action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${page.list}">
            <tr align="center">
                <td><input type="checkbox" name="ids" value="${user.id}"></td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.rolename}</td>
                <td><button><a href="/toEdit?id=${user.id}">修改</a></button></td>
                <td><button><a href="/delete?id=${user.id}">删除</a></button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <button type="submit" name="deletes">批量删除</button>

    <table align="center">
        <tr>
        <td>
            <span>
                当前是第${page.currentPage}页，共${page.totalPage}页，总记录数是${page.totalRecord}，每页显示${page.pageSize}条记录，
            </span>
            <span>
                <c:if test="${page.currentPage != 1}">
                    <a href="/index?currentPage=1">首页</a>
                    <a href="/index?currentPage=${page.currentPage-1}">上一页</a>
                </c:if>
                <c:if test="${page.currentPage != page.totalPage}">
                    <a href="/index?currentPage=${page.currentPage+1} ">下一页</a>
                    <a href="/index?currentPage=${page.totalPage}">尾页</a>
                </c:if>
            </span>
        </td>
    </tr>
    </table>
</form>

<form action="/outLogin">
    <table align="right">
        <tr>
            <td><input type="submit" value="退出登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
