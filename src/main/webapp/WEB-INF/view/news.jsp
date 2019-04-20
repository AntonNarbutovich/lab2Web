<%@ page import="com.company.myapp.model.entity.news.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style><%@include file="../style/style.css"%></style>

<html>
<head>
    <meta charset="UTF-8">
    <title>My super project!</title>
    <%--<link rel="stylesheet" type="text/css" href="../style/style.css"/>--%>
</head>
<body>
<header>
    <a href="http://localhost:8080">
        <div id="header-image">
            <%--<img src="../images/header.png" alt="wtf">--%>
            <p>MyApp</p>
        </div>
    </a>


    <a href="#btn">
        <div id="btn" class="header-region">
            <p>Music</p>
        </div>
    </a>

    <a href="#btn2">
        <div id="btn2" class="header-region">
            <p>Photos</p>
        </div >
    </a>

    <a href="#btn3">
        <div id="btn3" class="header-region">
            <p>News</p>
        </div>
    </a>
</header>

<div class="menu">

    <div id="btn4" class="menu-region">
        <input type="radio" name="radioMenu" checked="checked">
        <div>
        <p>All</p>
        </div>
    </div>

    <div id="btn5" class="menu-region">
        <input type="radio" name="radioMenu">
        <div>
        <p>Society</p>
        </div>
    </div>

    <div id="btn6" class="menu-region">
        <input type="radio" name="radioMenu">
        <div>
        <p>Sport</p>
        </div>
    </div>

    <div id="btn7" class="menu-region">
        <input type="radio" name="radioMenu">
        <div>
        <p>Politics</p>
        </div>
    </div>

    <div id="btn8" class="menu-region">
        <input type="radio" name="radioMenu">
        <div>
        <p>Art</p>
        </div>
    </div>
</div>

<div class="add">
    <a href="#openModal">
        <img src="../images/add.png" alt="add"/>
    </a>
</div>

<div id="openModal" class="modalWindow">
    <div>
    <form method="post" action="/news/add" enctype="multipart/form-data">
        <p>header</p><br>
        <input type="text" name="header">
        <p>content</p><br>
        <input type="text" name="text">
        <br>
        <p>Image</p><br>
        <input type="file" name="image">
        <br>
        <input type="submit" value="add">
    </form>
    </div>
</div>


<%for(News news: (ArrayList<News>)request.getAttribute("news")){
    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(news.getImage());

%>
<a href="/news/<%=news.getId()%>" class="newsPage">
<div class="news">
    <img src="data:image/jpg;base64, <%=b64%>" alt="not found" />
    <p><%=news.getHeader()%></p>
    <img src="../images/views.png" alt="views" class="views">
    <p class="views"><%=news.getViews()%></p>
</div>
</a>

<%}%>


</body>
</html>
