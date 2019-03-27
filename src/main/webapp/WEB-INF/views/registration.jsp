<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
    <div>
        <h1><spring:message code="app.title"/></h1>
    </div>

	<form:form action="${pageContext.request.contextPath}/registerAction" method="post" modelAttribute="userDTO">
        <table>
          <tr>
            <td><spring:message code="app.login.username"/></td>
            <td>
                <form:input path="username" type="text"/>
                <div><form:errors path="username"/></div>
            </td>
          </tr>
          <tr>
            <td><spring:message code="app.login.password"/></td>
            <td>
                <form:input path="password" type="password"/>
                <div><form:errors path="password"/></div>
            </td>
          </tr>
          <tr>
            <td><button type="submit"><spring:message code="app.login.button.login"/></button></td>
          </tr>
        </table>
  </form:form>
  <br/>
</body>
</html>