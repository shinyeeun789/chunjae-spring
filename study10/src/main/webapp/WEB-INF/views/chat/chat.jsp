<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> CHAT HOME </title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <div id="app">
        <div class="container">
            <div style="margin-top: 20px">
                <button class="waves-effect waves-light btn" id="chatList"><i class="material-icons left">cloud</i> 채팅방 목록 </button>
                <button class="waves-effect waves-light btn" id="createChat"><i class="material-icons left">cloud</i> 채팅방 만들기 </button>
            </div>
        </div>
    </div>
    <script>

    </script>
</body>
</html>
