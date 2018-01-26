<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 26.03.2015
  Time: 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
</head>

<body>
  <%@include file="../top.jsp"%>

  <p><h3>Поиск значения по таблице</h3></p>
  Выберете таблицу:
  <br>
  <form name="searchTable" action="/firstSearchServlet" method="get">
    <p><select size="1" name="selectTable">
      <option selected value="Группа">Группа</option>
      <option value="Студент">Студент</option>
    </select></p>
    <p><input type="submit" name="submit_1" value="Поск по одному атрибуту"></p>
    <p><input type="submit" name="submit_2" value="Поиск по всем аттрибутам"></p>
  </form>
</body>

</html>
