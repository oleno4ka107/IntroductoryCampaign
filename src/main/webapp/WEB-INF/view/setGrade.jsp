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

    <form method="post" action="${pageContext.request.contextPath}/university/admin/setgrade/button">


        <div class="input-field col s12">
            <select class="browser-default" name="student_id">
                <option disabled><fmt:message key="text.setmarks.name"/></option>
                <c:forEach items="${databaseListStudent}" var="student">
                    <option value="${student.getId()}">
                            ${student.getNameUa()}
                    </option>
                </c:forEach>

            </select>
            <select class="browser-default" name="subject">
                <option disabled><fmt:message key="text.setmarks.subject"/></option>
                <c:forEach items="${databaseListSubject}" var="subject">
                    <option value="${subject.getId()}">
                            ${subject.getName()}
                    </option>
                </c:forEach>

            </select>
        </div>
        <label>
            <input class="w3-input" type="number" required placeholder="<fmt:message key="text.setmarks.assessment"/>"
                   name="grade"/>
        </label>
        </p>
        <input class="btn" type="submit" value="<fmt:message key="text.set.marks"/>">
        <c:if test="${requestScope.userExist}">
            <div class="w3-container">
                <fmt:message key="text.user.not.exist"/>
                <fmt:message key="text.or"/>
                <fmt:message key="text.grade.valid"/>
            </div>
        </c:if>
    </form>


</div>


<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>
