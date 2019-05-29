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

<a href="#openModal">
    <div class="add">
        <p>Create card</p>
    </div>
</a>

<div id="openModal" class="modalWindow">
    <div class="add-user-table">
        <a class="close" href="#">&times;</a>
        <form method="get" action="${pageContext.request.contextPath}/card/add">
            <table class="employee-list">
                <c:forEach items="${no_card_employees}" var="emp">
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.surname}</td>
                        <td>${emp.role}</td>
                        <td><input type="radio" name="emp_id" value="${emp.id}" required></td>
                    </tr>
                </c:forEach>
                <br>FULFILL THE EMPLOYEE CARD
                    <br><%--<input type="text" name="mounth" value="mounth" required pattern="[^[a-zA-Z]+$]">--%>
                    <select name="mounth" required>
                        <option value="December">December</option>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                        <option value="July">July</option>
                        <option value="August">August</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                        <option value="November">November</option>
                    </select>
                    <input type="text" name="work_time" placeholder="enter work time" value="" required pattern="^([1-9][0-9]{0,2}|1000)$">
                    <%--input type="text" name="salary_type" value="salary_type"--%>
                    <select name="salary_type">
                        <option value="FIXED">FIXED</option>
                        <option value="TARIFF">TARIFF</option>
                     </select>
                    <input type="text" name="tariff" placeholder="enter tariff" value="" required pattern="^\d*$">
                    <input type="text" name="fixed_salary" placeholder="enter fixed salary" value="" required pattern="^\d*$">
                <br>SELECT THE USER
            </table>
            <c:if test="${no_card_employees.size() != 0}">
            <input id="add" type="submit" value="add" >
            </c:if>
        </form>
    </div>
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

<div class="user-table">
    <form method="get" action="${pageContext.request.contextPath}/card/update">
        <table class="employee-list">
        <caption><b>Employees</b></caption>
        <thead>
        <tr>
            <th id="name">name</th>
            <th id="surname">surname</th>
            <th id="role">role</th>
            <th id="select">select</th>
        </tr>
        </thead>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.role}</td>
                <td><input type="radio" name="id" value="${employee.id}" required></td>
            </tr>
        </c:forEach>
    </table>
        <input id="update" type="submit" value="update">
    </form>
</div>


</body>
</html>

