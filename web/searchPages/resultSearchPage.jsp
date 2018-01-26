<%@ page import="java.util.List" %>
<%@ page import="servlestDB.Group" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 02.04.2015
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат поиска</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>Результат: </p>

  <c:if test="${table == 'Группа'}">
    <table border="1">
      <tr>
        <td>Наименование группы</td>
        <td>Курс</td>
      </tr>

      <c:forEach items="${groups}" var="group">
        <tr>
          <td>${group.group_name}</td>
          <td>${group.course}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

  <c:if test="${table == 'Студент'}">
    <table border="1">
      <tr>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Группа</td>
      </tr>

      <c:forEach items="${students}" var="student">
        <tr>
          <td>${student.fname}</td>
          <td>${student.lname}</td>
          <td>${student.group_name}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

</body>
</html>
