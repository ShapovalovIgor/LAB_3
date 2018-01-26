<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 09.04.2015
  Time: 3:32
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

      if(fname.length == 0)
      {
        alert('Пожалуйста, введите Ваше имя');
        document.forms["form"]["fname"].focus();
        return false
      }
      if(lname.length == 0)
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

  <p>
  <p>Измените параметры студента:</p>
  <form name="form" action="/updateFinishStudentServlet" method="post" onsubmit="return validate()">
    <table border="1">
      <tr>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Группа</td>
      </tr>
      <tr>
        <input type="hidden"  name="stud_id" value="${stud_id}">
        <td><input type="text" name="fname" value="${fname}"></td>
        <td><input type="text" name="lname" value="${lname}"></td>
        <td><select name="group">
          <c:forEach items="${groups}" var="group">
            <option value="${group.group_id}">${group.group_name}</option>
          </c:forEach>
        </select></td>
      </tr>
    </table>
    <p><input type="submit" name="submit" value="Изменить"></p>
  </form>
  </p>
</body>
</html>
