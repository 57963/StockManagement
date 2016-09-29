<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="/styles/style.css">
    <script src="/scripts/userSearch.js"></script>
    <script>
        var users = {
            <c:forEach begin="0" end="${users.size()-1}" varStatus="i">
                <c:set var="user" value="${users.get(i.index)}"/>
                "${i.index}":{ID:${user.ID},name:"${user.fullName}",location:"${user.location.name}",rights:"${user.rights}"},
            </c:forEach>
        }
    </script>
</head>
<body onload="userFilter()">
<%@include file="../fragments/header.jspf"%>
<%@include file="../fragments/userdetails.jspf"%>
<%@include file="../fragments/navBar.jspf"%>
<div id="content">
    <table id="search" width="100%" >
        <colgroup>
            <col style="width:30px;">
            <col>
            <col>
            <col>
            <col style="width:21px;">
        </colgroup>
        <tr>
            <th style="width:10px">ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Rights</th>
            <th>×</th>
        </tr>
        <tr>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()" id="userID" class="filterInput" type="text"></td>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()" id="userName" class="filterInput" type="text"></td>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()" id="userLocation" class="filterInput" type="text"></td>
            <td><select onchange="userFilter()" style="padding:1px;height:21px" id="userRights" class="filterInput">
                <option>All</option>
                <option>Admin</option>
                <option>User</option>
            </select></td>
        </tr>
    </table>
    <br>
    <div id="addUser">
        <form autocomplete="off" style="margin:0;" action="/addUser" method="post">
            <input required id="firstName" type="text" name="firstName" placeholder="First Name"><br>
            <input required id="surname" type="text" name="surname" placeholder="Surname"><br>
            <select style="padding:1px;height:21px;width:65%" id="location" name="location"><br>
                <c:forEach items="${locations}" var="location">
                    <option>${location.name}</option>
                </c:forEach>
            </select>
            <select style="padding:1px;height:21px;width:35%;float: right;" id="rights" name="rights"><br>
                <option>Admin</option>
                <option>User</option>
            </select>
            <input id="submit" type="submit" value="Add">
        </form>
    </div>
</div>
</body>
</html>
