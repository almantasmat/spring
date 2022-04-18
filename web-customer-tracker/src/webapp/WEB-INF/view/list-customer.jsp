<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
<head>
    <%--        Reference --%>
    <link type="text/css" rel="stylesheet"
    <%--              kelias iki srs arba resources--%>
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <title>Customer List</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2> CRM - Customer relatsionship manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <%--put new button - add customer--%>
        <input type="button" value="Add customer" onclick="window.location.href='showFormForAdd';return false;"
               class="add-button"/>
    </div>
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <%--            looop a--%>
        <c:forEach var="customer" items="${customers}">
            <%--                    cunstrucct update link whit customer id--%>
            <c:url var="updateLink" value="/customer/showFormForUpdate">
                <c:param name="customerId" value="${customer.id}"></c:param>
            </c:url>
            <c:url var="deleteLink" value="/customer/delete">
                <c:param name="customerId" value="${customer.id}"></c:param>
            </c:url>
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>

                <td>
                        <%--                     display update link--%>
                    <a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}"
                    onclick="if(!(confirm('Are you sore you want to delete this customer?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>