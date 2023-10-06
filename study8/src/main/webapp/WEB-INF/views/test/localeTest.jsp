<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Locale Test</title>
</head>
<body>
    <nav>
        <a href="lang1"> 현재 언어 </a>
        <a href="lang2?lang=ko"> 한국어 </a>
        <a href="lang2?lang=en"> 영어 </a>
    </nav>
    <h2> <spring:message code="addBook.form.title.label" /> </h2>
    <hr>
    <h3> <spring:message code="addBook.form.subtitle.label" /> </h3>
    <p> <spring:message code="addBook.form.bookId.label" /> </p>
</body>
</html>
