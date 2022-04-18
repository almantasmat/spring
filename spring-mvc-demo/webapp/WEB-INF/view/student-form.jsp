<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student regitration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"></form:input>
    Last name: <form:input path="lastName"></form:input>
    <br><br>
    Country:
    <form:select path="country.">
        <form:options items="${student.countryOptions}"/>
<%--        <form:option value="Latvia" label="Latvia"/>--%>
<%--        <form:option value="Lenkija" label="Poland"/>--%>
<%--        <form:option value="Lietuva" label="Lithuania"/>--%>
    </form:select>
    <br><br>
    Favorite language:
    JAVA <form:radiobutton path="favLanguage" value="java"/>
    PHP <form:radiobutton path="favLanguage" value="php"/>
    <br><br>
    Favorite Operating system:
    Linux <form:checkbox path="operatingSystems" value="linux"/>
    Windows <form:checkbox path="operatingSystems" value="windows"/>
    <br><br>
    <input type="submit">
</form:form>

</body>
</html>