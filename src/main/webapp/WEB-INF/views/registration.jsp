<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html >
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
    <div>
        <h1><spring:message code="app.title"/></h1>
    </div>

	<form:form action="${pageContext.request.contextPath}/registerAction" modelAttribute="user" method="post">
        <table>
          <tr>
            <td><spring:message code="app.login.username"/></td>
            <td>
                <form:input path="username" type="text"/>
                <form:errors path="username"/>
            </td>
          </tr>
          <tr>
            <td><spring:message code="app.login.password"/></td>
            <td>
                <form:input path="password" type="password"/>
                <form:errors path="password"/>
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