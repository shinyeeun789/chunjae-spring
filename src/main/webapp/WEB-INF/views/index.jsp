<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>티스푼 메인 페이지</title>
    <jsp:include page="./include/head.jsp"/>
</head>
<body>
    <div class="container is-fullhd">
        <jsp:include page="./include/hd.jsp"/>
        <section class="hero is-medium is-link">
            <div class="hero-body">
                <p class="title">
                    Medium hero
                </p>
                <p class="subtitle">
                    Medium subtitle
                </p>
            </div>
        </section>
        <div class="contents">
            ${today } <h2> ${myName } </h2>
        </div>

        <jsp:include page="./include/ft.jsp"/>
    </div>
</body>
</html>