<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-29
  Time: 오전 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change</title>
</head>
<body>
<form method="post" action="/user/change">
  <input type ="text" value="${username}" name="username">
  <input type="text" value="${password}" name="password">
  <input type="submit" value="변경">
</form>
<a href="/todo/main">메인으로가기</a>

</body>
</html>
