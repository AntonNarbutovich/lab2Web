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

<%--<a href="#openModal">
    <div  class="add">
        <p>Update user</p>
    </div>
</a>--%>
<div class="user-table">
        <form method="post" action="${pageContext.request.contextPath}/card/update_finish">
            <input type="hidden" name="card_id" value="${emp_card.id}">
            <table class="employee-list">
                <tr>
                    <th id="mounth">mounth</th>
                    <th id="work_time">work_time</th>
                    <th id="salary_type">salary_type</th>
                    <th id="tariff">tariff</th>
                    <th id="fixed_salary">fixed_salary</th>
                </tr>
                <tr>
                    <td>${emp_card.mounth}</td>
                    <td>${emp_card.work_time}</td>
                    <td><%--<input type="text" name="salary_type" value="${emp_card.salary_type}">--%>
                    <select name ="salary_type">salary_type
                        <option value="FIXED">FIXED</option>
                        <option value="TARIFF">TARIFF</option>
                    </select></td>
                    <td><input type="text" name="tariff" placeholder="enter tariff" value="${emp_card.tariff}" required pattern="^\d*$"></td>
                    <td><input type="text" name="fixed_salary" placeholder="enter fixed salary" value="${emp_card.fixed_salary}" required pattern="^\d*$"></td>

                </tr>
            </table>
            <input id="update_finish" type="submit" value="update_finish">
        </form>
</div>

<%--<a href="#openModal">
    <div class="delete">
        <p>Update user</p>
    </div>
</a>

<div id="openModal" class="modalWindow">
    <div class="delete-user-table">
        <a class="close" href="#">&times;</a>
        <form method="post" action="${pageContext.request.contextPath}/card/update">
            <table class="employee-list">
                <c:forEach items="${cards}" var="cards">
                    <c:if test = "${id == cards.id}">
                    <tr>
                        <td><input type="text" name="id" value="${cards.id}"></td>
                        <td><input type="text" name="mounth" value="${cards.mounth}"></td>
                        <td><input type="text" name="work_time" value="${cards.work_time}"></td>
                        <td><input type="text" name="salary_type" value="${cards.salary_type}"></td>
                        <td><input type="text" name="tariff" value="${cards.tariff}"></td>
                        <td><input type="text" name="fixed_salary" value="${cards.fixed_salary}">
                    </tr>
                    </c:if>
                </c:forEach>
            </table>
            <input id="update" type="submit" value="update">
        </form>
    </div>
</div>--%>
</body>
</html>