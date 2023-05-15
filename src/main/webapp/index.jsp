<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<% if (session.getAttribute("name") == null) {--%>
<%--    response.sendRedirect("login");--%>
<%--}--%>
<%--%>--%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <h1 class="text-blue-600"><%= "Hello World!" %></h1>
    <br/>
    <a href="login">Login</a>
    <a href="register">Register</a>
    <h1> <%= session.getAttribute("name") %> </h1>
</body>
</html>