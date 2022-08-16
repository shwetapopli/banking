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
	background-image:url("images/register.jpg");
}
input[type="submit"]{
background-color: mediumblue;
color: whitesmoke;
width: 175px;
cursor: pointer;
}
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</style>
</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h1>REGISTER</h1>
	<form:form method="post" action="addusersave">	
			<form:input path="firstName" required="required"  placeholder="First Name" />
		<br><br>
			<form:input path="lastName" required="required"  placeholder="Last Name"/>
		<br><br>
			<form:input path="email" required="required"  placeholder="Email"/>
		<br><br>		
			<form:input path="username" required="required" placeholder="Username" />
		<br><br>
			<form:input type="password" path="password" required="required"  placeholder="Password"/>
		<br><br>
			<form:input type="confirmPassword" path="password" required="required"  placeholder="Confirm password"/>
		<br><br>
			<form:input path="phone" required="required"  placeholder="Phone"/>
		<br><br>
		<form:input path="sinNumber" required="required"  placeholder="SIN Number"/>
		<br><br>	
		<input type="submit" value="Register" />
		<br><br><br><br>

		<a href="./" style="background: azure;" >Back to Home page </a>
	</form:form>
	<br />
	<br />
</body>
</html>