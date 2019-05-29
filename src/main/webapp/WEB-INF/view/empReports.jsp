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
    <a href="${pageContext.request.contextPath}/info">
        <div id="current-user" class="header-region">
            <% String image;   try{image = javax.xml.bind.DatatypeConverter.printBase64Binary((byte[]) request.getAttribute("image"));}
            catch (Exception e){ image=null; };
            %>
            <img src="data:image/jpg;base64, <%=image%>" alt="avatar" onerror=this.src="../images/emptyAvatar.png">
        </div>
    </a>
</header>

<c:forEach items="${reports}" var="card">

<div class="user-table">
    <table class="employee-list">
        <caption><b>Report for ${card.mounth} with ${card.salary_type} payment<br>${name} ${surname}</b></caption>
        <thead>
        <tr>
            <th id="Payment type">Payment type</th>
            <th id="Sum">Sum</th>
            <th id="Working hours">working hours</th>
        </tr>
        </thead>
        <c:if test="${card.salary_type == 'FIXED'}">
            <tr>
                <td>Fixed</td>
                <td>${card.fixed_salary}</td>
                <td>${card.work_time}</td>
            </tr>
        <tr>
            <td>Extra hours</td>
            <td>-</td>
            <td>-</td>
        </tr>
        </c:if>
        <c:if test="${card.salary_type == 'TARIFF'}">
        <c:if test="${card.work_time <= 176}">
        <tr>
            <td>Tariff</td>
            <td>${card.tariff * card.work_time}</td>
            <td>${card.work_time}</td>
        </tr>
        <tr>
            <td>Extra hours</td>
            <td>0</td>
            <td>0</td>
        </tr>
        </c:if>
            <c:if test="${card.work_time > 176}">
                <tr>
                    <td>Tariff</td>
                    <td>${((card.work_time - 176) * card.tariff * 1.5) + card.tariff * 176} </td>
                    <td>${card.work_time}</td>
                </tr>
                <tr>
                    <td>Extra hours</td>
                    <td>${(card.work_time - 176) * card.tariff * 1.5}</td>
                    <td>${card.work_time - 176}</td>
                </tr>
            </c:if>
        </c:if>
    </table>
</div>
        </c:forEach>


</body>
</html>
