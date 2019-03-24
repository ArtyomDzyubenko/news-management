<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News management</title>
</head>
<body>
	<h1>News management</h1>
	<h2>${message}</h2>

	<form action='<spring:url value="/logout"/>' method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>