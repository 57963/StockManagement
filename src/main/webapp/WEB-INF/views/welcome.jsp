<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="/styles/style.css">
</head>
<body>
<%@ include file="../fragments/header.jspf"%>
<div id="userBar">
    <form action="/login" method="post">
        <input id="username" type="text" name="username" placeholder="Username">
        <input id="password" type="password" name="password" placeholder="Password">
        <input id="submit" type="submit" value="Login">
    </form>
    <span style="font-size: medium; color: red;">${error}</span>
</div>
</body>
</html>