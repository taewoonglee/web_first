<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-29
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Like</title>
</head>
<body>
<form method="post" action="/todo/like">
    <input type="number" value="${todoid}" name = "user_id">
    <input type="text" value = "${content}" name = "content">
    <input type="submit">
</form>

</form>

</body>
</html>
