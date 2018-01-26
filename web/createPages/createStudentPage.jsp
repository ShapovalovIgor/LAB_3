<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 09.04.2015
  Time: 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    function validate()
    {
      var fname = document.forms["form"]["fname"].value;
      var lname = document.forms["form"]["lname"].value;

      if(name.length == 0)
      {
        alert('Пожалуйста, введите Ваше имя');
        document.forms["form"]["fname"].focus();
        return false
      }
      if(course.length == 0)
      {
        alert('Пожалуйста, введите Фамилию');
        document.forms["form"]["lname"].focus();
        return false
      }

      return true
    }
  </script>
</head>
<body>
  <%@include file="/top.jsp"%>

  <p>Добавление студента:</p>
  <p>
    <form name="form" action="/createFinishStudentServlet" method="post" onsubmit="return validate()">
      Имя:
      <p><input type="text" name="fname"></p>
      Фамилия:
      <p><input type="text" name="lname"></p>

      <p>Выберете группу</p>
      <p><select name="group">
        <c:forEach items="${groups}" var="group">
          <option value="${group.group_id}">${group.group_name}</option>
        </c:forEach>
      </select></p>
      <input type="submit" value="Добавить студента">
    </form>
  </p>
</body>
</html>
