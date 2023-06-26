<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-26
  Time: 오전 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/user/login">
    <input type ="text" name="id" value="${id}">
    <input type="text" name="pw">
    <input type ="checkbox" name = "idSave" checked ="${idSave}" VALUE="true">
    <input type="submit" value="로그인">
</form>
<a href="/user/signup">회원가입</a>
</body>
</html>
