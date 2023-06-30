
<%@ page import="com.naver.user.domain.entity.TodoJoinUser" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<h1>${name} 환영합니다.</h1>
<a href="/user/login">돌아가기</a>
<a href="/user/change">변경하기</a>
<div>
    <form action="/todo/main" method="post">
        <input type="text" name="content" placeholder="content를 추가합니다">
        <input type="submit">
    </form>
</div>
<form action="/todo/main" method="get">

    <input type="text" name="keyword" placeholder="찾고싶은 단어를 입력하세요">
    <input type="submit" value="검색">
</form>
<table>
    <tr>
        <td>id</td>
        <td>content</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>check</td>
        <td>수정</td>
    </tr>
    <c:forEach items="${todolist}" var = "todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.content}</td>
            <td>${todo.name}</td>
            <td>${todo.createAt}</td>
            <td>${todo.checked}</td>
            <c:set var="id" value="${sessionScope.get(\"id\")}"/>
            <c:if test="${id eq todo.uid}">
                <td>
                    <a href="/todo/todoupdate?todoid=${todo.id}">수정
                    </a>
                </td>
            </c:if>
                <td>
                    <form method="post" action="/todo/like">
                        <input type="hidden" name="todoid" value="${todo.id}">
                        <input type="submit" value = "${todo.heart}">
                    </form>
                    </a>
                </td>
        </tr>
    </c:forEach>
    <%--<%--%>
    <%--    List<TodoJoinUser> todos = (List<TodoJoinUser>)request.getAttribute("todolist");--%>
    <%--    if(todos!=null && todos.size() != 0){--%>
    <%--        for (TodoJoinUser todo :todos) {%>--%>
    <%--            <tr>--%>
    <%--                <td><%= todo.getId()%></td>--%>
    <%--                <td><%= todo.getContent()%></td>--%>
    <%--                <td><%= todo.getCreateAt()%></td>--%>
    <%--                <td><%= todo.getName()%></td>--%>
    <%--                <td><%= todo.isChecked()%></td>--%>
    <%--                <%--%>
    <%--                    if(session.getAttribute("uid") == todo.getUid()){--%>
    <%--                %>--%>
    <%--                <td>--%>
    <%--                    <a href="/todoupdate?todoid=<%= todo.getId()%>">수정</a>--%>
    <%--                </td><%--%>
    <%--                    }--%>
    <%--                %>--%>
    <%--            </tr>--%>
    <%--        <%--%>
    <%--        }--%>
    <%--    }--%>
    <%--    %>--%>
</table>
<body>

</body>
</html>
