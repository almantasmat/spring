<%--
  Created by IntelliJ IDEA.
  User: alman
  Date: 2022-02-14
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom Page</title>
    <style>.failed{color: red;}</style>
</head>
<body>
<h3>My custom login page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
<%--    Check for login errors--%>
    <c:if test="${param.error != null}">
        <i class="failed">Sorry you entered invalid username or password</i>
    </c:if>
   <p>User name: <input type="text" name="username"/> <p/>
       <p>Password:<input type="password" name="password"/><p/>
    <p>Password:<input type="submit" value="login"/><p/>
</form:form>
</body>
</html>
