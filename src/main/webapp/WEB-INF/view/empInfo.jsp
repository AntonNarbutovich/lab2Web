<%@ page import="com.company.myapp.model.entity.Employee" %>
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
            <% String image;
                Employee emp = (Employee) request.getAttribute("emp");
                try{image = javax.xml.bind.DatatypeConverter.printBase64Binary(emp.getImage());}
                catch (Exception e){ image=null; };
            %>
            <img src="data:image/jpg;base64, <%=image%>" alt="avatar" onerror=this.src="../images/emptyAvatar.png">
        </div>
    </a>
</header>
<div class="container">
    <div class="user-image">
        <img src="data:image/jpg;base64, <%=image%>" alt="avatar" onerror=this.src="../images/emptyAvatar.png">
    </div>

    <a href="${pageContext.request.contextPath}/perform_logout">
        <div class="logout">
            <p>Logout</p>
        </div>
    </a>
    <div class="user-info">
        <b><%=emp.getName()%> <%=emp.getSurname()%> </b>
        <br>
        <p><%=emp.getRole()%></p>
    </div>
</div>

</body>
</html>
