<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 05.04.2015
  Time: 6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    function validate()
    {
      var name = document.forms["form"]["name"].value;
      var course = document.forms["form"]["course"].value;

      if(name.length == 0)
      {
        alert('Пожалуйста, введите наименование группы');
        document.forms["form"]["name"].focus();
        return false
      }
      if(course.length == 0)
      {
        alert('Пожалуйста, введите Курс');
        document.forms["form"]["course"].focus();
        return false
      }

      return true
    }
  </script>
</head>
<body>
  <%@include file="../top.jsp"%>

  <p>
    <p>Измените параметры группы:</p>
    <form name="form" action="/updateFinishGroupServlet" method="post" onsubmit="return validate()">
      <table border="1">
        <tr>
          <td>Наименование группы</td>
          <td>Курс</td>
        </tr>
        <tr>
            <input type="hidden"  name="id" value="${group_id}">
            <td><input type="text" name="name" value="${group_name}"></td>
            <td><input type="number" name="course" value="${course}" min="1" max="4"></td>
        </tr>
      </table>
        <p><input type="submit" name="submit" value="Изменить"></p>
    </form>
  </p>
</body>
</html>
