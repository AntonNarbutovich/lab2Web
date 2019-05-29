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

<div class="success">
    <h1>Error</h1>
    <p>${error}</p>
</div>

<a href="${pageContext.servletContext.contextPath}/emp">
    <div class="return">
        <p>Go back</p>
    </div>
</a>



</body>
</html>
