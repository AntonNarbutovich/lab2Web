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
    <a href="${contextPath}">
        <div id="header-image">
            <%--<img src="../images/header.png" alt="wtf">--%>
            <p>lab2</p>
        </div>
    </a>
    <a href="${contextPath}/reports/#btn">
        <div id="btn" class="header-region">
            <p>Reports</p>
        </div>
    </a>

    <a href="${contextPath}/card#btn2">
        <div id="btn2" class="header-region">
            <p>Salary</p>
        </div >
    </a>

    <a href="${contextPath}/emp#btn3">
        <div id="btn3" class="header-region">
            <p>Employees</p>
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/info">
        <div id="current-user" class="header-region">
            <% String image;   try{image = javax.xml.bind.DatatypeConverter.printBase64Binary((byte[]) request.getAttribute("image"));}
            catch (Exception e){ image=null; };
            %>
            <img src="data:image/jpg;base64, <%=image%>" alt="avatar" onerror=this.src="../images/emptyAvatar.png">
        </div>
    </a>
</header>

<div class="user-table">
<table class="employee-list">
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td><a href="${contextPath}/reports/${emp.id}">${emp.name}</a></td>
            <td>${emp.surname}</td>
            <td>${emp.role}</td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
