<%--
  Created by IntelliJ IDEA.
  User: alman
  Date: 2022-02-11
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<H2>Company home page</H2>
<br><hr>
Welcome to company page!
<p></p>
<%--display user name and roles--%>

<p>User name: <security:authentication property="principal.username"/></p>
<p>User role: <security:authentication property="principal.authorities"/></p>

<security:authorize access="hasRole('MANAGER')">
<%--add link to point to/leaders. This is foe managers--%>
<p></p>
<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
(Only for managers)
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/systems">Systems info</a>
(Only for administrator)
</security:authorize>

<%--add logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
