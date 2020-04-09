<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить пользователя</title>
</head>
<body>
<h1 style="text-align: center">Добавьте пользователя</h1>
<hr>
<form style="text-align: center" method="post" action="/add">
    <label for="name">Имя:</label>
    <input id="name" type="text" name="name">
    <input type="submit" value="Добавить">
</form>
<p></p>
<form style="text-align: center" method="get" action="/">
    <input type="submit" value="К списку">
</form>
</body>
</html>