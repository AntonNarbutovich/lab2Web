<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="../style/style.css"%></style>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>My super project!</title>
    <%--<link rel="stylesheet" type="text/css" href="../style/style.css"/>--%>
</head>
<body>
<header>
    <a href="#btn">
        <div id="header-image">
            <%--<img src="../images/header.png" alt="wtf">--%>
            <p>lab2</p>
        </div>
    </a>
    <a href="#btn">
        <div id="btn" class="header-region">
            <p>Reports</p>
        </div>
    </a>

    <a href="#btn2">
        <div id="btn2" class="header-region">
            <p>Salary</p>
        </div >
    </a>

    <a href="${contextPath}/emp#btn3">
        <div id="btn3" class="header-region">
            <p>Employees</p>
        </div>
    </a>
    <a href="#btn">
        <div id="current-user" class="header-region">
            <img src="" alt="avatar" onerror=this.src="../images/emptyAvatar.png">
        </div>
    </a>
</header>

<a href="#openModal">
<div class="add">
    <p>Add user</p>
</div>
</a>

<div id="openModal" class="modalWindow">
    <div class="add-user-table">
        <a class="close" href="#">&times;</a>
        <form method="post" action="${pageContext.request.contextPath}/emp/add">
        <table class="employee-list">
            <c:forEach items="${users_to_add}" var="emp">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.surname}</td>
                    <td>${emp.role}</td>
                    <td><input type="radio" name="id" value="${emp.id}"></td>
                </tr>
            </c:forEach>
        </table>
            <input id="add" type="submit" value="add">
        </form>
    </div>
</div>

<a href="#openModal2">
    <div class="delete">
        <p>Delete user</p>
    </div>
</a>

<div id="openModal2" class="modalWindow">
    <div class="delete-user-table">
        <a class="close" href="#">&times;</a>
        <form method="post" action="${pageContext.request.contextPath}/emp/delete">
            <table class="employee-list">
                <c:forEach items="${users_to_delete}" var="emp">
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.surname}</td>
                        <td>${emp.role}</td>
                        <td><input type="radio" name="id" value="${emp.id}"></td>
                    </tr>
                </c:forEach>
            </table>
            <input id="delete" type="submit" value="delete">
        </form>
    </div>
</div>

<div class="user-table">
<table class="employee-list">
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.role}</td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
