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
    <h1 class="flow-text"><fmt:message key="text.admin.studentlist"/></h1>

    <table class="highlight">

        <thead>
        <tr><c:choose>
            <c:when test="${language == 'ua'}">
                <th><fmt:message key="text.name.ua"/></th>
                <th><fmt:message key="text.surname.ua"/></th>
                <th><fmt:message key="text.setmarks.assessment"/></th>
            </c:when>
            <c:otherwise>
                <th><fmt:message key="text.name.en"/></th>
                <th><fmt:message key="text.surname.en"/></th>
                <th><fmt:message key="text.setmarks.assessment"/></th>
            </c:otherwise>
        </c:choose>
        </tr>
        </thead>
        <c:forEach items="${studentsList}" var="student">
            <tbody>
            <tr>
                <c:choose>
                    <c:when test="${language == 'ua'}">
                        <td> ${student.getNameUa()} </td>
                        <td> ${student.getSurnameUa()} </td>
                    </c:when>
                    <c:otherwise>
                        <td> ${student.getNameEn()} </td>
                        <td> ${student.getSurnameEn()} </td>
                    </c:otherwise>
                </c:choose>
                <td> ${student.getSumOfaccessment()} </td>
                <td>

                    <a class="btn"
                       href="${pageContext.request.contextPath}/university/admin/сhangestudent?id=${student.getId()}"><i
                            class="material-icons">create</i></a>
                </td>
                <td>
                    <a class="btn"
                       href="${pageContext.request.contextPath}/university/admin/deletestudent?id=${student.getId()}"><i
                            class="material-icons ">delete</i></a>
                </td>
            </tr>
            </tbody>

            </tbody>
        </c:forEach>
    </table>
</div>
</body>
<jsp:include page="/WEB-INF/parts/footer.jsp"/>
</html>
