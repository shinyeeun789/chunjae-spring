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
    <input type="text" name="num" id="num" placeholder="연번 입력" required><br>
    <input type="text" name="title" id="title" placeholder="제목 입력" required><br>
    <button id="btn8" type="button"> Post 전송 </button>
    <button id="empty" type="button"> 결과 비우기 </button>
    <hr>
    <h3> 결과 목록 </h3>
    <div id="res">
        <table id="tb1">
            <thead>
            <tr><th> 연번 </th><th> 제목 </th></tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
    <script>
        $(document).ready(function () {
            $("#btn8").click(function () {
                var test = { "num": parseInt($("#num").val()), "title": $("#title").val() };
                var txt = "";
                $.ajax({
                    type: "post",
                    url : "${path1}/ajax/test8pro",
                    data: JSON.stringify(test),
                    dataType: "json",
                    contentType: "application/json",
                    success: function(res) {
                        console.log("성공", res);
                        for(let i in res) {
                            console.log(res[i]);
                            txt = txt + "<tr><td>"+res[i].num+"</td><td>"+res[i].title+"</td></tr>";
                        }
                        $("#tb1 tbody").html(txt);

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
