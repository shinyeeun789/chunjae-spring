<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <title> testInsert </title>
</head>
<body>
    <h2> testInsert </h2>
    num : <input type="text" id="num" name="num" required>
    title : <input type="text" id="title" name="title" required>
    <input type="button" id="btn1" value="전송">
    <script>
        $(document).ready(function() {
            $("#btn1").click(function() {
                var test = { "num": $("#num").val(), "title": $("#title").val() };
                $.ajax({
                    type: "post",
                    url: "${path}/json/insertForm",                 // Controller 상에서 @ModelAttribute로 받는 경우
                    data: test,                                     // 일반 객체로 전송
                    success: function(res) {
                        console.log("성공", res);
                    },
                    error: function(request, status, err) {
                        console.log("실패", err);
                    }
                });
            });
        });
    </script>
</body>
</html>
