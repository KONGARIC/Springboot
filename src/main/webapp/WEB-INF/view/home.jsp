<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<head>
</head>
<body>

<h>Home page</h>
<p>wellcome<p>

User : <security:authentication property="principal.username" />
Role : <security:authentication property="principal.authorities" />

<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
    <p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(only for managers)
    </p>
</security:authorize>

 <form:form action="${pageContext.request.contextPath}/logout"
        method="POST">

        <input type="submit" value="Logout"/>
        </form:form>



</body>