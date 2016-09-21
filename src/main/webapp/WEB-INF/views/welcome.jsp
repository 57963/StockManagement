<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">

    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/scripts/sketch.js"></script>
    <script>
        function draw() {
            //fdraw(${r},${g},${b});
        }
    </script>
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/lib/p5.min.js"></script>
</head>
<body>
<%@ include file="../fragments/header.jspf"%>
<div id="userBar">
    <form id="login" action="/login" method="post">
        <input id="username" type="text" name="username" placeholder="Username">
        <input id="password" type="password" name="password" placeholder="Password">
        <input id="submit" type="submit" value="Login">
    </form>
</div>
${location}
</body>
</html>