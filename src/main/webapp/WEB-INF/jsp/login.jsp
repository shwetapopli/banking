<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
body{
 	font: 28px Arial, sans-serif;
	text-align: center;
  	background-image: url("images/icicibank.png")
}
form {
float: left;
position: relative;
left: 83px;
top: 70px;
}
input[type="submit"]{
background-color: mediumblue;
color: whitesmoke;
width: 100%;
cursor: pointer;
}
</style>

</head>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
		<form:form method="post" action="customerLoginCheck">
					<form:input path="username" required="required" placeholder="USERNAME"/> <br>
					<form:input type= "password" path="password" required="required" placeholder="PASSWORD" /> <br>
			        <input type="submit" value="Login"/> <br> <br>
 			  
			        <a href="/index/registerUser">Register </a></br></br>
			        <a href="/index/forgotPassword">Forgot Password </a>
		</form:form>


</body>
</html>