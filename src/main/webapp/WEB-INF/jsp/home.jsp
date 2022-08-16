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
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
	background-image:url("images/home.jfif");
}

form {
	border: 3px solid #f1f1f1;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
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
	float: right;
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

#menu {list-style: none; list-style: none;text-align: left;font-size: 20px;}
#menu li { padding: 0px; }
#menu li a { margin: 0px; display: block; width: 100%; height: 100%; }
.quickLinks{
float:left;
}
</style>

<body>
		<div class="navbar">
			<div align="right" class="dropdown" >
				<button class="dropbtn">Logout</button>
				<div class="dropdown-content">
					<a href="./">Logout</a>
				</div>
			</div>
		</div>

		<br />
		<div>
			<h1 style="text-align:center;margin:10px;" >WELCOME TO ONLINE BANKING</h1>
			<br>
			<div class="details">
				<h2>Welcome ${param.username}</h2>
				<h2>Customer ID : ${param.custid}</h2>
				<h2>Savings Account Balance : ${param.sbalance}</h2>
				<h2>Account Number : ${param.accountNumber}</h2>
			</div>
			<div class="quickLinks">
<ul id="menu">
			<li>
				 <a href="/index/depositamount/${param.custid}/${param.sbalance}"> Deposit Money</a> &nbsp;&nbsp;&nbsp;
</li>
			<li>				 
<a href="/index/withdrawamount/${param.custid}/${param.sbalance}">Withdraw Money </a> &nbsp;&nbsp;&nbsp;
</li>
			<li>
				 <a href="/index/transferamount/${param.custid}/${param.sbalance}"> Transfer Money </a> &nbsp;&nbsp;&nbsp;
</li>
			<li>				
 <a href="/index/utilitiesamount/${param.custid}/${param.sbalance}/${param.dueAmount}"> Pay Utilities </a>	&nbsp;&nbsp;&nbsp; 
			</li>
			</ul>
			</div>

	<footer> </footer>
</body>
</html>