<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-26
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<form method="post" action="/user/signup">
  <input type ="text" name ="id">
  <input type ="text" name ="pw">
    <input type = "text" name = "name">
  <input type = "submit" value="회원가입">
</form>
</body>
</html>
