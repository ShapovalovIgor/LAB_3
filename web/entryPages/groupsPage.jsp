<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 04.04.2015
  Time: 7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>Группы: </p>
  <table border="1">
    <tr>
      <td>Наименование группы</td>
      <td>Курс</td>
      <td>Студенты группы</td>
      <td>Изменить</td>
      <td>Удалить</td>
    </tr>

    <c:forEach items="${groups}" var="group">
      <tr>
        <td>${group.group_name}</td>
        <td>${group.course}</td>
        <td><a href="<c:url value="/studentsInGroupServlet">
                      <c:param name="group_id" value="${group.group_id}"></c:param>
                      <c:param name="group_name" value="${group.group_name}"></c:param>
                    </c:url>">Студенты группы</a></td>
        <td><a href="<c:url value="/updateGroupServlet">
                      <c:param name="group_id" value="${group.group_id}"></c:param>
                      <c:param name="group_name" value="${group.group_name}"></c:param>
                      <c:param name="course" value="${group.course}"></c:param>
                    </c:url>">Изменить</a></td>
        <td><a href="<c:url value="/deleteGroupServlet">
                      <c:param name="group_id" value="${group.group_id}"></c:param>
                    </c:url>">Удалить</a></td>
      </tr>
    </c:forEach>
  </table>

  <p>
    <form action="/createPages/createGroupPage.jsp" method="get">
      <input type="submit" name="submit" value="Добавить группу">
    </form>
  </p>
</body>
</html>
