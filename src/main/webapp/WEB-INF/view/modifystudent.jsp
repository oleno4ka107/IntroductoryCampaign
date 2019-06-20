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
    <a class="waves-effect waves-light btn" href="{pageContext.request.contextPath}/university/admin/setgrade?studentId=${studentId}"><i class="material-icons left-button">grade</i><fmt:message key="text.add.marks"/></a>
    <form action="${pageContext.request.contextPath}/university/admin/modifystudent/send?studentId=${studentId}" align="center" method="post">

        <p>
            <label>
                <input type="text" pattern="^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$" required
                       placeholder="<fmt:message key="text.name.ua"/>" name="nameUa" value="${nameUa}"/>
            </label>
        </p>
        <p>
            <label>
                <input type="text" pattern="^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$" required
                       placeholder="<fmt:message key="text.surname.ua"/>" name="surnameUa" value="${surnameUa}"/>
            </label>
        </p>
        <p>
            <label>
                <input type="text" pattern="^[A-Z][a-z]{1,20}$" required placeholder="<fmt:message key="text.name.en"/>"
                       name="nameEn" value="${nameEn}"/>
            </label>
        </p>
        <p>
            <label>
                <input type="text" pattern="^[A-Z][a-z]{1,20}$" required
                       placeholder="<fmt:message key="text.surname.en"/>" name="surnameEn" value="${surnameEn}"/>
            </label>
        </p>
        <p>
            <label>
                <input type="email" required placeholder="<fmt:message key="text.email"/>" name="email" value="${email}"/>
            </label>
        </p>

        <c:forEach items="${speciatlyList}" var="specialty">
            <p>
                <label>
                    <input type="text" required placeholder="<fmt:message key="text.email"/>" name="email" value="${email}"/>
                </label>
            </p>
        </c:forEach>
        <div>
            <input type="submit" class="btn right" value="<fmt:message key="text.admin.button.change"/>">
            <c:if test="${requestScope.modifyError}">
            <div>
                <fmt:message key="text.rerisration.error"/>
            </div>
            </c:if>
            <c:if test="${requestScope.userExist}">
            <div>
                <fmt:message key="text.user.exist"/>
            </div>
            </c:if>

    </form>
</div>
</div>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>