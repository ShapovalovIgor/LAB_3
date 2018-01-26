<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 30.03.2015
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
</head>
<body>
  <%@include file="../top.jsp"%>

  Выбрана таблица: ${table}
  <p>Выберете атрибут:</p>

  <c:set var="table" value="${table}"></c:set>

  <c:if test="${table == 'Группа'}">
      <p>
        <form name="searchGroup" action="/secondSearchServlet" method="get">
          <select size="1" name="selectAtributs">
            <option value="Наименование группы">Наименование группы</option>
            <option value="Курс">Курс</option>
          </select>
          <br>
          <input type="submit" value="Выбрать">
        </form>
      </p>
  </c:if>

  <c:if test="${table == 'Студент'}">
    <p>
      <form name="searchStudent" action="/secondSearchServlet" method="get">
        <select size="1" name="selectAtributs">
          <option value="Имя">Имя</option>
          <option value="Фамилия">Фамилия</option>
          <option value="Группа">Группа</option>
        </select>
        <br>
       <input type="submit" value="Выбрать">
      </form>
    </p>
  </c:if>

</body>
</html>
