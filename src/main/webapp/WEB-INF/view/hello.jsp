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
            <img src="../images/emptyAvatar.png" alt="avatar"/>
        </div>
    </a>
</header>



</body>
</html>
