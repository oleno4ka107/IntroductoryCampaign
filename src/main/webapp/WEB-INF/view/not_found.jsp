<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="text.title"/></title>
    <jsp:include page="/WEB-INF/parts/header.jsp"/>
    <title>Error 404</title>

</head>
<body>
<div class="container">
    <H1 class="flow-text"> Error 404</H1>
    <form method="post"
          action="${pageContext.request.contextPath}/university/main">
        <input type="hidden">
        <button class="btn" type="submit"><fmt:message key="text.main"/></button>
    </form>
</div>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>
