<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>HBS</title>
</head>
<body>
<div>
<h4>Enter details to Register</h4>
<form action="register" method="post" >
	<label for="name"></label>
    <input type="text"  name="name" placeholder="Your name..">
    
	<label for="username"></label>
    <input type="text"  name="username" placeholder="Your username..">

	<label for="password"></label>
    <input type="password"  name="password" placeholder="Your password..">
    
    <label for="email"></label>
    <input type="text"  name="email" placeholder="Your email..">
    
	<label for="mobile"></label>
    <input type="text"  name="mobile" placeholder="Your mobile..">

	<input type="submit" value="submit">
	<a href="login.jsp">Back to Login</a>
</form>
</div>
</body>
</html>