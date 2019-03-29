<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
    <div>
        <h1><spring:message code="app.login.form.name"/></h1>
    </div>

	<form action='<spring:url value="/loginAction"/>' name="loginForm" method="post">
        <table>
          <tr>
            <td><spring:message code="app.login.username"/></td>
            <td>
                <input type="text" name="username" min="3" max="20" required/>
            </td>
          </tr>
          <tr>
            <td><spring:message code="app.login.password"/></td>
            <td>
                <input type="password" name="password" min="8" max="20" required/>
            </td>
          </tr>
          <tr>
            <td><button type="submit"><spring:message code="app.login.button.login"/></button></td>
          </tr>
        </table>
  </form>
    <div>
        <a href="<spring:url value="/register"/>"><spring:message code="app.register.form.name"/></a>
    </div>
  <br/>
</body>
</html>
