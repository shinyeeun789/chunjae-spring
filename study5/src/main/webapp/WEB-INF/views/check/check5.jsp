<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Springframework Validation @InitBinder+@Valid</title>
</head>
<body>
<h2> Springframework Validation @InitBinder+@Valid를 이용한 유효성 검증 </h2>
<hr>
<form action="./check5pro" method="post">
    id : <input type="text" name="id" id="id" /><br><br>
    pw : <input type="password" name="pw" id="pw" /><br><br>
    <button type="submit">확인</button>
</form>
</body>
</html>
