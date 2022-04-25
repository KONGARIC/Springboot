<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
.failed{
color:red;
}
</style>

<head>
</head>
<body>
<h3>Custom login page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
        method="POST">
        <c:if test="${param.error!=null}">
        <i class="failed">You have entered invalid email/password </i>
        </c:if>
        <p>
            User name: <input type="text" name="username" />
        </p>
        <p>
           Password: <input type="password" name="password" />
        </p>
        <input type="submit" value="Login"/>
        </form:form>

</body>
</html>