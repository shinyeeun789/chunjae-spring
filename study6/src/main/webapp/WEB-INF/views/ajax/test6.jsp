<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Post + @ModelAttribute + Object 전송 </title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <ul>
        <li><a href="${path1}/ajax/"> HOME </a></li>
    </ul>
    <input type="text" name="age" id="age" placeholder="나이 입력" required><br>
    <input type="text" name="name" id="name" placeholder="이름 입력" required><br>
    <button id="btn6" type="button"> Post 전송 </button>
    <script>
        $(document).ready(function () {
            $("#btn6").click(function () {
                var human = { "age": parseInt($("#age").val()), "name": $("#name").val() };
                $.ajax({
                    type: "post",
                    url : "${path1}/ajax/test6pro",
                    data: human,
                    success: function(res) {
                        console.log("성공", res);
                    },
                    error: function(err) {
                        console.log("실패", err);
                    }
                });
            });
        });
    </script>
</body>
</html>
