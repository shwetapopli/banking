<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body {
	text-align: center;
	background-color: powderblue;
}


</style>
</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h1>REGISTER</h1>
	<form:form method="post" action="/index/forgotpassword">		
			<form:input path="userName" required="userName" placeholder="Username" />	
			<br><br>
			<form:input path="newPassword" required="required" placeholder="New Password" />
		<br><br>
			<form:input type="confirmNewPassword" path="confirmNewPassword" required="required"  placeholder="Confirm New Password"/>
		<br><br>	
		<input type="submit" value="Submit" />
		<br><br><br><br>
		<a href="./">Back to Home page </a>
	</form:form>
	<br />
	<br />
</body>
</html>