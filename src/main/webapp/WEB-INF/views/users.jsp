<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="/styles/style.css">
    <script src="/scripts/userSearch.js"></script>
    <script>
        var locations ={
            <c:forEach begin="0" end="${locations.size()-1}" varStatus="i">
            <c:set var="location" value="${locations.get(i.index)}"/>
            "${i.index}":{ID:'${location.ID}',name:'${location.name}'},
            </c:forEach>
        };

        function getLocationfromID(ID){
            for(var i = 0; i<Object.keys(locations).length;i++){
                if(locations[i].ID == ID){
                    return locations[i];
                }
            }
        }

        var users = {
            <c:forEach begin="0" end="${users.size()-1}" varStatus="i">
                <c:set var="user_" value="${users.get(i.index)}"/>
                "${i.index}":{ID:${user_.ID},firstName:"${user_.firstName}",surname:"${user_.surname}",location:getLocationfromID(${user_.location.ID}),rights:"${user_.rights}"},
            </c:forEach>
        };
    </script>
</head>
<body onscroll="iconUpdate()" onload="userFilter()">
<%@include file="../fragments/header.jspf"%>
<%@include file="../fragments/userdetails.jspf"%>
<%@include file="../fragments/navBar.jspf"%>
<div id="content">
    <div id = "form"></div>
    <table id="search" width="100%" >
        <colgroup>
            <col style="width:30px;">
            <col style="width:50%;">
            <col style="width:50%;">
            <col style="width:100px;">
            <col style="width:21px;">
            <col style="width:21px;">
        </colgroup>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Rights</th>

        </tr>
        <tr>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()"  style="width:30px;" id="userID" class="filterInput" type="text"></td>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()" id="userName" class="filterInput" type="text"></td>
            <td><input onkeypress="userFilter()" onkeyup="userFilter()" id="userLocation" class="filterInput" type="text"></td>
            <td><select onchange="userFilter()" style="width:100px;padding:1px;height:21px" id="userRights" class="filterInput">
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
            <select style="padding:1px;height:21px;width:65%" id="location" name="location">
                <c:forEach items="${locations}" var="location">
                    <option>${location.name}</option>
                </c:forEach>
            </select>
            <select style="padding:1px;height:21px;width:35%;float: right;" id="rights" name="rights">
                <option>Admin</option>
                <option>User</option>
            </select><br>
            <input id="submit" type="submit" value="Add">
        </form>
    </div>
</div>
</body>
</html>
