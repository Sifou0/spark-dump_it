<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %><html>
<head>
	<title>Title</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess}">
		<h1>Dump Success</h1>
	</c:when>
	<c:otherwise>
		<h1>Dump Failed</h1>
	</c:otherwise>
</c:choose>
</body>
</html>
