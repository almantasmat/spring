<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

    <TITLE>CRM-Customer Relationship manager</TITLE>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css/"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css/"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <H2>Customer form</H2>
    </div>
    </div>
    <div id="container">
        <h3>Save customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
<%--            need asociate this data whit customer id--%>
<%--         saveCustomer metodas custumerControler !!!!!!--%>
            <form:hidden path="id"></form:hidden>
            <table>
                <tbody>
                <tr>
                    <td><label> First Name: </label></td>
                    <td><form:input path="firstName"></form:input></td>
                    </tr>
                    <tr>
                    <td><label> Last Name: </label></td>
                    <td><form:input path="lastName"></form:input></td>
                    </tr>
                    <tr>
                    <td><label> Email: </label></td>
                    <td><form:input path="email"></form:input></td>
                    </tr>
                <tr>
                    <Td></Td>
                    <td><input type="submit" value="save" class.save></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear: both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        </p>
    </div>

</body>
</html>