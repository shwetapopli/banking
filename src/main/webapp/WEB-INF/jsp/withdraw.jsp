<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>



<style>
@charset "ISO-8859-1";
body {
	background-image: url("images/cad.png");
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
}
input[type="submit"]{
background-color: mediumblue;
color: whitesmoke;
width: 10%;
cursor: pointer;
}


/* menu */
.navbar {
	border-radius: 10px;
	overflow: hidden;
	background-color: #335;
}

.navbar a {
	border-radius: 10px;
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
	right: 6px;
    position: relative;
    cursor: pointer;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: #1B5BD2;
}

.dropdown-content {
	border-radius: 18px;
	display: none;
	position: absolute;
	background-color: #f9f9f9;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.container {
text-align:left;
}
</style>

<body>
	<div class="container">
		<div class="navbar">
			<div class="dropdown">
				<button class="dropbtn">Home</button>
				<div class="dropdown-content">
					<a href="/index/accountmain/${param.custid}">Home</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">Logout</button>
				<div class="dropdown-content">
					<a href="/index">Logout</a>
				</div>
			</div>
		</div>

		<br />
		<div>
			<h1>Withdraw Amount</h1>
			<br>
			<div align="left">
				<h2 style="color: navy; font-size: 40px;"></h2>
				<h2>Customer ID : ${param.custid}</h2>
				<h2>Savings Account Balance : ${param.sbalance}</h2>
				<h2>Account Number : ${param.accountNumber}</h2>
			</div>

			<form:form method="POST" action="/index/withdrawAmount/${param.custid}">
			
				<form:hidden path="custid"  />
					Enter Amount :
					<form:input type="text" path="Balance" required="required"/>
					<input type="submit" value="Withdraw Amount" />
		</form:form>
		</div>
	</div>

	<footer> </footer>
</body>
</html>