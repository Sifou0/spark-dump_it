<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <script src="https://kit.fontawesome.com/98642eab86.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./assets/css/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
    <div class="logo">
        <img src="https://www.spark-archives.com/sites/default/files/images/capital.png" id="logo" alt="logo spark"/>
    </div>
    <div class="form-wrapper p-top">
        <form action="available" method="post" class="">
            <c:if test="${canBack}">
                <div class="form-wrapper p-top">
                        <div class="">
                            <input class="backButton" type="submit" name="backButton" value="Go back"/>
                        </div>
                </div>
            </c:if>
            <c:forEach var="i" items="${dumpDirList}">
                <div class="">
    <%--                <i class="fa-solid fa-folder"></i>--%>
                    <input class="dirButton" id="dirButton" type="submit" name="dirButton" value="${i}"/>
                </div>
            </c:forEach>
        </form>
    </div>
    <div class="form-wrapper">
        <form action="import"  method="post">
            <c:forEach var="i" items="${dumpFileslist}">
                <div class="">
                    <input type="radio" value="${i}" name="fileName"/>
                    <label for="fileName">${i}</label>
                </div>
            </c:forEach>
                <div class="form-wrapper p-top">
                    <input type="submit" name="execButton" class="backButton" value="Exécuter"/>
                </div>
        </form>
    </div>
</div>
</body>
</html>
