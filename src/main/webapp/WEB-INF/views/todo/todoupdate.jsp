<%--
  Created by IntelliJ IDEA.
  User: Playdata
  Date: 2023-06-19
  Time: 오후 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>todoupdate</title>
</head>
<body>
  <form method="post" action="/todo/todoupdate">
    <input type="text" value="${user_id}" name = "user_id">
    <input type="text" value = "${content}" name = "content">
    <input type="submit">
  </form>
</body>
</html>
