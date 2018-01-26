<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 08.04.2015
  Time: 10:10
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
          alert('Пожалуйста, введите Ваше имя');
          document.forms["form"]["name"].focus();
          return false
        }
        if(course.length == 0)
        {
          alert('Пожалуйста, введите курс');
          document.forms["form"]["course"].focus();
          return false
        }
        if(course <= 0 || course > 4)
        {
          alert('Задайте курс от 1 до 4');
          document.forms["form"]["course"].focus();
          return false
        }

        return true
      }
    </script>
</head>
<body>
  <%@include file="/top.jsp"%>

  <p>Создание группы:</p>
<p>
  <form action="/createGroupServlet" name="form" method="post" onsubmit="return validate()">
    <table>
      <tr>
        <td>Наименование группы:</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>Курс</td>
        <td><input type="number"  name="course"></td>
      </tr>
    </table>
    <p><input type="submit" value="Создать"></p>
  </form>
</p>
</body>
</html>
