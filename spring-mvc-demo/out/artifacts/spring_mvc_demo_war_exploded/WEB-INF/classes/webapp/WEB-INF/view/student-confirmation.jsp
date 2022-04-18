<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
Student is confimed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Favorite language: ${student.favLanguage}
<br><br>
Favorite operating system:
<ul>
    <c var="operationSystem" items="${student.operatingSystems}">
    <li>
        ${operationSystem}
    </li>
        </c>
</ul>
</body>

</html>