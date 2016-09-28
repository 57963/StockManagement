<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head Office Home -  ${user.firstName} ${user.surname}</title>
    <link rel="stylesheet" href="/styles/style.css">
    <script src="/scripts/navBar.js"></script>
    <script src="/lib/p5.min.js"></script>
    <script src="/lib/p5.dom.js"></script>
    <script src="/scripts/profitGraph.js"></script>
    <script>
        var locations ={
            <c:forEach items="${locations}" var="location">
                "${location.ID}":
                {name:"${location.name}", sales:{
                <c:forEach items="${location.sales}" var="sales">
                    "${sales.week}":{net: "${sales.net}"},
                </c:forEach>
                }, weeks:${location.sales.size()}},
            </c:forEach>
        };
        var locLength = ${locations.size()};
    </script>
</head>
<body onResize="resize()" onScroll="iconUpdate()">
<%@ include file="../fragments/header.jspf"%>
<%@ include file="../fragments/userdetails.jspf"%>

<nav id="navBar">
    <span onclick="toggleNav();">&#9776;</span>
    <ul>
        <li onclick="toggleSublist('locationsSublist', ${locations.size()*21})">Locations</li>
        <ul class="sublist"  id="locationsSublist" >
            <c:forEach items="${locations}" var="location">
                <li>${location.name}</li>
            </c:forEach>
        </ul>
        <li onclick="toggleSublist('usersSublist', ${users.size()*21})">Staff</li>
        <ul class="sublist" id="usersSublist" >
            <c:forEach items="${users}" var="user">
                <li>${user.fullName}</li>
            </c:forEach>
        </ul>
        <li>Stock</li>
    </ul>
</nav>
<div id="content">
    <div id = "profitGraph">
    </div>

</div>
</body>
</html>
