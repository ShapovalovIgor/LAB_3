<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 02.04.2015
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице</title>
  <script type="text/javascript">
    function validOne()
    {
      var text = document.forms["formOne"]["text"].value;
      if(text.length ==0)
      {
        alert("Введите аттрибут");
        return false
      }
      return true
    }
    function validGroup()
    {
      var group_name = document.forms["formGroup"]["group_name"].value;
      var course = document.forms["formGroup"]["course"].value;
      if(group_name.length == 0)
      {
        alert("Введите имя группы");
        return false
      }
      if(course.length = 0)
      {
        alert("Введите курс");
        return false
      }
      return true
    }
    function validStudent()
    {
      var group_name = document.forms["formStudent"]["group_name"].value;
      var fname = document.forms["formStudent"]["fname"].value;
      var lname = document.forms["formStudent"]["lname"].value;
      if(group_name.length = 0)
      {
        alert("Введите имя группы");
        return false
      }
      if(fname.length = 0)
      {
        alert("Введите имя студента");
        return false
      }
      if(lname.length = 0)
      {
        alert("Введите фамилию студента");
        return false
      }
      return true
    }
  </script>
</head>
<body>
  <%@include file="../top.jsp"%>
  <c:set var="submit" value="${pageContext.session.getAttribute('submit')}"></c:set>
  <c:set var="table" value="${pageContext.session.getAttribute('table')}"></c:set>

  <c:if test="${submit == 'Поск по одному атрибуту'}">
    Выбран атрибут: ${atribute}
    <p>
      Введите значение атрибута:
      <form name="formOne" action="/threeSearchServlet" method="get" onsubmit="return validOne()">
        <input type="text" name="text">
        <br>
        <input type="submit" name="sub_one" value="ввести">
      </form>
    </p>
  </c:if>

  <c:if test="${submit == 'Поиск по всем аттрибутам'}">
    Введите значения атрибутов:
    <br>
    <c:if test="${table == 'Группа'}">
      <form name="formGroup" action="/threeSearchServlet" method="get" onsubmit="return validGroup()">

        <br>
        Наименование группы
        <p><input type="text" name="group_name"></p>
        Курс
        <p><input type="number" name="course" min="1" max="4"></p>
        <input type="submit" name="sub_all_group" value="ввести">
      </form>
    </c:if>

    <c:if test="${table == 'Студент'}">
      <form name="formStudent" action="/threeSearchServlet" method="get" onsubmit="return validStudent()">
        <br>
        Имя
        <p><input type="text" name="fname"></p>
        Фамилия
        <p><input type="text" name="lname"></p>
        Группа
        <p><input type="text" name="group_name"></p>
        <input type="submit" name="sub_all_student" value="ввести">
      </form>
    </c:if>
  </c:if>

</body>
</html>
