<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script
            src="https://kit.fontawesome.com/98642eab86.js"
            crossorigin="anonymous"
    ></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="flex justify-center p-4 w-screen ">
    <form class="w-1/3">
        <c:forEach var="i" items="${dumpDirList}">
        <div
                class="text-center my-2 rounded bg-blue-300 p-1 text-white hover:bg-blue-400"
        >
            <i class="fa-solid fa-folder"></i>
            <input class="" type="submit" value="${i}" />
        </div>
        </c:forEach>
        <c:forEach var="i" items="${dumpFileslist}">
        <div class="text-center my-2 rounded p-1 min-w-max">
            <input type="checkbox" id="${i}" name="${i}" />
            <label for="${i}">${i}</label>
        </div>
        </c:forEach>
    </form>
</div>
</body>
</html>
