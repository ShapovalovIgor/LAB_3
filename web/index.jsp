<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 17.03.2015
  Time: 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Подключение к базе данных</title>
  </head>
  <body>
    Подключиться к базе данных:
    <br>
    <br>

    <form name="FormStart" action="startServlet" method="get">
      <table>
        <tr>
          <td>Введите логин:</td>
          <td><input type="text" name="login" value="bronze"></td>
        </tr>
        <tr>
          <td>Введите пароль:</td>
          <td><input type="password" name="password" value="bronze"></td>
        </tr>
      </table>
      <input type="submit" name="connect" value="connect">
    </form>
  </body>
</html>
