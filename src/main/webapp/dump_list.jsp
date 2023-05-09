<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="i" items="${dump_list}">
        <li>${i}</li>
    </c:forEach>
</ul>
</body>
</html>
