<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <style>
        .wrapper {
            display: flex;
            align-items: center;
            min-height: 75vh;
        }

    </style>
    <title><fmt:message key="text.title"/></title>
</head>
<body>


<nav>
    <div class="nav-wrapper">
        <div class="container">
            <a class="brand-logo"><fmt:message key="text.title"/></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="${pageContext.request.contextPath}/university/main"><fmt:message key="text.main"/></a></li>
                <li><a href="${pageContext.request.contextPath}/university/logout"><fmt:message key="text.logout"/></a>
                </li>
                <li><a href="${pageContext.request.contextPath}/university/language/en">English</a></li>
                <li><a href="${pageContext.request.contextPath}/university/language/ua">Українська</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="wrapper">


</body>
</html>
