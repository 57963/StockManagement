<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head Office Home -  ${user.firstName} ${user.surname}</title>
    <link rel="stylesheet" href="/styles/style.css">
    <script src="/lib/p5.min.js"></script>
    <script src="/lib/p5.dom.js"></script>
    <script src="/scripts/profitGraph.js"></script>
    <script>
        var locations ={
            <c:forEach items="${locations}" var="location">
                "${location.ID}": {name:"${location.name}", sales:{
                <c:forEach items="${location.sales}" var="sales">
                    "${sales.week}":{net: "${sales.net}"},
                </c:forEach>
                }},
            </c:forEach>
        };
    </script>
</head>
<body onResize="resize()" onScroll="iconUpdate()">
<%@ include file="../fragments/header.jspf"%>
<%@ include file="../fragments/userdetails.jspf"%>
<%@include file="../fragments/navBar.jspf"%>
<div id="content">
    <div id = "profitGraph">
    </div>
</div>
</body>
</html>
