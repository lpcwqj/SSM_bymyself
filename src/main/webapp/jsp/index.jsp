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
    <title>paging</title>
</head>
<body>
<form id="form0" name="form1" method="post" action="/fuzzyQuery">
    username: <input type="text" name="username" placeholder="Query by username">&nbsp;&nbsp;
    <%--rolename: <input type="text" name="id">&nbsp;&nbsp;--%>
    <input type="submit" value="Query">
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
                <td><button><a href="/toEdit?id=${user.id}">edit</a></button></td>
                <td><button><a href="/delete?id=${user.id}">delete</a></button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <button type="submit" name="deletes">BatchDeletion</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button><a href="../jsp/add.jsp">AddUser</a></button>


    <table align="center">
        <tr>
        <td>
            <span>
                The current page is ${page.currentPage},with ${page.totalPage} page and ${page.totalRecord} records.Each page shows ${page.pageSize} records
            </span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span>
                <c:if test="${page.currentPage != 1}">
                    <a href="/index?currentPage=1">Home</a>
                    <a href="/index?currentPage=${page.currentPage-1}">Previous</a>
                </c:if>
                <c:if test="${page.currentPage != page.totalPage}">
                    <a href="/index?currentPage=${page.currentPage+1} ">Next</a>
                    <a href="/index?currentPage=${page.totalPage}">End</a>
                </c:if>
            </span>
        </td>
    </tr>
    </table>
</form>

<form action="/outLogin">
    <table align="right">
        <tr>
            <td><input type="submit" value="logout"></td>
        </tr>
    </table>
</form>
</body>
</html>
