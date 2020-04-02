<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Make booking</title>
</head>
<body>
<h3>Enter your password to confirm</h3>
<div>
<form action="bookrooms" method="post" >
Password :<input type="password" name="password" placeholder="Your password.."></input><br/>
<input type="submit" value="submit">
</form>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Abort and Logout">
</form>
</div>
</body>
</html>