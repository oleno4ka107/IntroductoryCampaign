<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${language}">
<head>
    <jsp:include page="/WEB-INF/parts/header.jsp"/>
    <title><fmt:message key="text.title"/></title>
    <style>
        .mb15 {
            margin: 0 0 15px;
        }

        .row {
            display: flex;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s12 m6">
            <h1 class="flow-text mb15"><fmt:message key="text.student.page"/></h1>
            <form method="post"
                  action="${pageContext.request.contextPath}/university/studentPage/department">
                <input type="hidden">
                <button class="btn" type="submit"><fmt:message key="text.departament"/></button>
            </form>

            <form method="post"
                  action="${pageContext.request.contextPath}/university/studentPage/studentRating">
                <input type="hidden">
                <button class="btn" type="submit"><fmt:message key="text.student.rating"/></button>
            </form>
        </div>
        <div class="col s12 m6">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <div>
                        <c:choose>
                            <c:when test="${language == 'ua'}">
                                <fmt:message key="text.name.ua"/>
                                <c:out value="${nameUa}"/>
                                <br>
                                <fmt:message key="text.surname.ua"/>
                                <c:out value="${surnameUa}"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="text.name.en"/>
                                <c:out value="${nameEn}"/>
                                <br>
                                <fmt:message key="text.surname.ua"/>
                                <c:out value="${surnameEn}"/>
                            </c:otherwise>
                        </c:choose>
                        <br>
                        <fmt:message key="text.email"/>
                        <c:out value="${email}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>
