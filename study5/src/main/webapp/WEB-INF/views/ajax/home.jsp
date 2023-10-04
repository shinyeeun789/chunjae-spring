<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> AJAX HOME </title>
</head>
<body>
    <nav>
        <ul>
            <li><a href="${path1}/ajax/test1"> 01_Get 전송 </a></li>
            <li><a href="${path1}/ajax/test2"> 02_Post 전송 </a></li>
            <li><a href="${path1}/ajax/test3"> 03_Get + Parameter </a></li>
            <li><a href="${path1}/ajax/test4"> 04_Post + Parameter </a></li>
            <li><a href="${path1}/ajax/test5"> 05_Get + @ModelAttribute + Object 전송 </a></li>
            <li><a href="${path1}/ajax/test6"> 06_Post + @ModelAttribute + Object 전송 </a></li>
            <li><a href="${path1}/ajax/test7"> 07_Post + @RequestBody + Object 전송 </a></li>
            <li><a href="${path1}/ajax/test8"> 08_Post + Parameter + List 전송 </a></li>
            <li><a href="${path1}/ajax/test9"> 09_Post + Parameter + ResponseEntity + Object 전송 </a></li>
            <li><a href="${path1}/ajax/test10"> 10_Post + Parameter + ResponseEntity + List 전송 </a></li>
        </ul>
    </nav>
</body>
</html>
