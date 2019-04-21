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
<div class="container" style="width: 100%;">
    <c:url value="/perform_login" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signing-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Login" required>
        <br>
        <input type="password" class="form-control" name="j_password" placeholder="Password" required>
        <br>
        <button class="login" type="submit">Login</button>
    </form>
</div>


</body>
</html>
