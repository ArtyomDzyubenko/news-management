<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
    <div>
        <h1><spring:message code="app.title"/></h1>
    </div>

	<form:form action="${pageContext.request.contextPath}/registerAction" method="post" modelAttribute="user">
        <table>
          <tr>
            <td><spring:message code="app.login.username"/></td>
            <td>
                <form:input path="username" type="text" min="3" max="20"/>
                <div class="msg-val"><form:errors path="username"/></div>
            </td>
          </tr>
          <tr>
            <td><spring:message code="app.login.password"/></td>
            <td>
                <form:input path="password" type="password" min="3" max="20"/>
                <div class="msg-val"><form:errors path="password"/></div>
            </td>
          </tr>
          <tr>
            <td><button type="submit"><spring:message code="app.register.button.reg"/></button></td>

          </tr>
          <tr>
              <td></td>
              <td class="msg-val">
                  <c:if test="${userExist == true}">
                      <spring:message code="app.register.user.exist"/>
                  </c:if>
              </td>
          </tr>
        </table>
  </form:form>
  <br/>
</body>
</html>