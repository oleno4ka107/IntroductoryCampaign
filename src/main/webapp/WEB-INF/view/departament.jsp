
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="text.title"/></title></head>
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container">
    <h1 class="flow-text"><fmt:message key="text.departament"/></h1>


    <div class="input-field col s12">

        <form method="post" action="${pageContext.request.contextPath}/university/studentpage/departament/set">
            <div class="input-field col s12">
                <select class="browser-default" name="specialty">
                    <option disabled><fmt:message key="text.set.specialty"/></option>
                    <c:forEach items="${speciatlyList}" var="specialty">
                        <option value="${specialty.getId()}">
                                ${specialty.getTitle()}
                        </option>
                    </c:forEach>

                </select>

            </div>
            <input class="btn" type="submit" value="<fmt:message key="text.set.specialty"/>">
        </form>
    </div>
</div>

<c:if test="${setSpecialty}">
    <div class="w3-container">
        <fmt:message key="text.set.your.spectialty"/>
    </div>
</c:if>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>
