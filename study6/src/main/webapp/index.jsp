<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="resources/css/normalize.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation-prototype.min.css">
    <link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.js"></script>
</head>
<body>
<header id="header">

</header>

<div class="container">
    <div class="content" id="con">
        <c:if test="${empty sid}">
            <a href="${path1}/user/loginForm"> 로그인 </a>
            <a href="${path1}/user/agree"> 회원가입 </a>
        </c:if>
        <c:if test="${!empty sid}">
            <a href="${path1}/admin/list"> 회원 목록 </a>
            <hr>
            <a href="${path1}/user/read"> 내 정보 보기 </a>
            <a href="${path1}/user/update"> 회원 정보 변경 </a>
            <a href="${path1}/user/delete"> 회원 탈퇴 </a>
            <a href="${path1}/user/logout"> 로그아웃 </a>
        </c:if>
        <hr>
        <a href="${path1}/fileupload/fileUpload2"> 파일 업로드2 </a>
        <a href="${path1}/fileupload/fileUpload3"> 파일 업로드3 </a>
    </div>
</div>

<footer id="footer">

</footer>

</body>
</html>
