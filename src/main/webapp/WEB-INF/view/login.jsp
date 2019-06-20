<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<fmt:setBundle basename="text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="text.title"/></title>
</head>
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container">

    <h1 class="flow-text"><fmt:message key="text.enter.login.and.password"/></h1>

    <form action="${pageContext.request.contextPath}/university/login" method="post">
        <fmt:message key="text.login"/> <input type="email" name="login" required="required"/>
        <fmt:message key="text.password"/> <input type="password" name="password" required="required"/>

        <input type="submit" class="btn" value=
        <fmt:message key="text.enter"/>>

        <c:if test="${requestScope.notFound}">
            <div class="w3-container">
                <fmt:message key="text.invalidData"/>
            </div>
        </c:if>
    </form>
    <form action="${pageContext.request.contextPath}/university/registration" method="post">
        <input class="btn" type="submit" value= <fmt:message key="text.registration"/>>
    </form>


</div>


<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>
