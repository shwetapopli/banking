<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html>
<html>
<head>
<title>Index</title>
</head>
<style>

body 
{
	font: 28px Arial, Helvetica, sans-serif;
	text-align: center;
	background-image: url("images/Scotiabank.png")
}
</style>
<body>
<h3 style="background-color: floralwhite;width: 398px;font-size: revert;font-family: cursive;">Welcome to ScotiaBank Internet Banking</h3>
<form style="text-align: left;background-color: floralwhite;width: 21%;font-family: cursive;">
	    <h3>New to Internet Banking</h3>
		<a href="registerUser"> Register here </a>
		<h3>Existing User</h3>
		<a href="login"> Login </a>
	</form> 
</body>
</html>
