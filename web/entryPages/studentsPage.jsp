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

  <p>Студенты:</p>
  <table border="1">
    <tr>
      <td>Имя</td>
      <td>Фамилия</td>
      <td>Группа</td>
      <td>Изменить</td>
      <td>Удалить</td>
    </tr>
      <c:forEach items="${students}" var="student">
          <tr>
              <td>${student.fname}</td>
              <td>${student.lname}</td>
              <td>${student.group_name}</td>
              <td><a href="<c:url value="/updateStudentServlet">
                             <c:param name="stud_id" value="${student.stud_id}"></c:param>
                             <c:param name="fname" value="${student.fname}"></c:param>
                             <c:param name="lname" value="${student.lname}"></c:param>
                             <c:param name="st_group_id" value="${student.st_group_id}"></c:param>
                             <c:param name="group_name" value="${student.group_name}"></c:param>
                           </c:url>">Изменить</a></td>
              <td><a href="<c:url value="/deleteStudentServlet">
                               <c:param name="stud_id" value="${student.stud_id}"></c:param>
                             </c:url>">Удалить</a></td>
         </tr>
      </c:forEach>
  </table>

  <p>
    <form action="/createStudentServlet" method="get">
      <input type="submit" value="Добавить студента">
    </form>
  </p>
</body>
</html>
