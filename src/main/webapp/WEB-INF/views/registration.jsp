<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
    <div>
        <h1><spring:message code="app.title"/></h1>
    </div>

	<form action='<spring:url value="/registerAction"/>' name="registerForm" th:object="${user}" method="post">
        <table>
          <tr>
            <td><spring:message code="app.login.username"/></td>
            <td>
                <input type="text" name="username" th:field="*{username}" required/>
            </td>
          </tr>
          <tr>
            <td><spring:message code="app.login.password"/></td>
            <td>
                <input type="password" name="password" th:field="*{password}" required/>
            </td>
          </tr>
          <tr>
            <td><button type="submit"><spring:message code="app.login.button.login"/></button></td>
          </tr>
        </table>
  </form>
  <br/>
</body>
</html>