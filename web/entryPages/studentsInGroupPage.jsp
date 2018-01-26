<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 05.04.2015
  Time: 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>Студенты в группе ${group_name}:</p>
  <table border="1">
    <tr>
      <td>Имя</td>
      <td>Фамилия</td>
    </tr>

    <c:forEach items="${students}" var="student">
      <tr>
        <td>${student.fname}</td>
        <td>${student.lname}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
