<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Ajax Test1 </title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<nav>
    <ul>
        <li><a href="${path1}/ajax/"> HOME </a></li>
    </ul>
    <button id="btn1"> Get 전송 </button>
    <script>
        $(document).ready(function() {
            let fn1 = () => $.ajax({
                type: "get",
                url: "${path1}/ajax/test1pro?msg=데이터전송",
                success: function(res) {
                    console.log("성공", res);
                },
                error: function(err) {
                    console.log("실패", err);
                }
            });
            $("#btn1").on("click", fn1());
        });
    </script>
</nav>
</body>
</html>
