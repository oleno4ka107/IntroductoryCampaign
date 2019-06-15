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
</head>
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container">
    <h1 class="flow-text"><fmt:message key="text.admin.page"/></h1>
    <div class="center-pill">

        <form role="form" method="post"
              action="${pageContext.request.contextPath}/university/admin/setGrade">
            <button class="btn" type="submit"><fmt:message key="text.set.marks"/></button>
        </form>


        <form role="form" method="post"
              action="${pageContext.request.contextPath}/university/admin/sendNotification">
            <button class="btn" type="submit"><fmt:message key="text.notification"/></button>
        </form>
    </div>
</div>
</body>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</html>
