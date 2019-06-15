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
<style>
    .row .col {
        padding: 0;
    }

</style>
<body>
<jsp:include page="/WEB-INF/parts/header.jsp"/>
<div class="container">
    <h1 class="flow-text"><fmt:message key="text.student.rating"/></h1>

    <div>
        <form method="post" action="${pageContext.request.contextPath}/university/studentPage/studentRating/show">
            <div class="input-field col s12">
                <select class="browser-default" name="specialty">
                    <option selected disabled hidden style='display: none' value=''></option>
                    <option disabled hidden><fmt:message key="text.set.specialty"/></option>

                    <c:forEach items="${speciatlyList}" var="specialty">
                        <option value="${specialty.getId()}">
                                ${specialty.getTitle()}
                        </option>
                    </c:forEach>

                </select>
            </div>
            <input class="btn" type="submit" value="<fmt:message key="text.set.specialty"/>">
        </form>


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
            <c:forEach items="${studentsReceivedList}" var="student">
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
                </tr>
                </tbody>

                </tbody>
            </c:forEach>
        </table>
    </div>
    <jsp:include page="/WEB-INF/parts/footer.jsp"/>
</body>
</html>

