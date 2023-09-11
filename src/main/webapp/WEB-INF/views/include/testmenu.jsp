<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 테스트 메뉴 </title>
</head>
<body>
<ul class="list">
    <li><a href="${path1}/sample/main.do">RequestMapping 방식 : Get</a></li>
    <li><a href="${path1}/sample/get1.do?id=shin&pw=1234">GetMapping 방식 : request+model</a></li>
    <li><a href="${path1}/sample/get2.do?id=shin&pw=1234">RequestMapping.GET 방식 : request+model</a></li>
    <li><a href="${path1}/sample/get3.do?id=shin&pw=1234">RequestMapping.GET 방식 : RequestParam+model</a></li>
    <li><a href="${path1}/sample/get4.do?id=shin&pw=1234">RequestMapping.GET 방식 : dto+model</a></li>
    <li><a href="${path1}/sample/get5.do?id=shin&pw=1234">RequestMapping.GET 방식 : ModelAttribute+model</a></li>
    <li><a href="${path1}/sample/get6.do/shin/1234">RequestMapping.GET 방식 : PathVariable+model</a></li>
    <li><a href="${path1}/sample/get7.do?id=shin&pw=1234">RequestMapping.GET 방식 : RequestParam+ModelAndView</a></li>
    <li><a href="${path1}/sample/list.do"> sampleList </a></li>
    <li><a href="${path1}/board/list.do"> boardList </a></li>
</ul>
</body>
</html>
