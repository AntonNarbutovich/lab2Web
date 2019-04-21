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
<a class="logout" href="${pageContext.request.contextPath}/perform_logout">Logout</a>

</body>
</html>
