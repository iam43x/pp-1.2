<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1 style="text-align: center">Список пользователей</h1>
<hr>
<table style="margin-left: auto;margin-right: auto">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var='user' items="${users}">
        <tr>
            <form style="text-align: center">
            <td style="text-align: center">${user.getId()}</td>
            <td style="text-align: center"><input type="text" name="name" value="${user.getName()}"></td>
            <td style="text-align: center">
            <input type="hidden" name="id" value="${user.getId()}">
            <input type="submit" value="Delete" formmethod="post" formaction="/del">
            <input type="submit" value="Update" formmethod="get" formaction="/updt"></form>
            </td>
        </tr>
    </c:forEach></table>
<form style="text-align: center" method="get" action="/add">
     <input type="submit" value="Create">
</form>
</body>
</html>