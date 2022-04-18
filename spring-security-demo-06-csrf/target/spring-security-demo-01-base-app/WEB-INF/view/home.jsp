<%--
  Created by IntelliJ IDEA.
  User: alman
  Date: 2022-02-11
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<H2>Company home page</H2>
<br><hr>
Welcome to company page!
<p></p>
<%--add logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
