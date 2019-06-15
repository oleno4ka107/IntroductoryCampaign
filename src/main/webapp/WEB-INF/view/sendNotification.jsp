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
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container">
    <h1 class="flow-text"><fmt:message key="text.send.notification"/></h1>

    <form method="post"
          action="${pageContext.request.contextPath}/university/admin/sendNotification/send">

        <input type="text" required placeholder="<fmt:message key="text.email"/>" name="email"/>


        <button class="btn" type="submit"><fmt:message key="text.send"/></button>
    </form>
</div>
</body>
</html>