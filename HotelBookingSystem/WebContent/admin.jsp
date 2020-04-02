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
<h4>Welcome To HBS</h4>
<form action="adminlogin" method="post" >
	<label for="username">Admin Username</label>
    <input type="text"  name="username" placeholder="Your username..">

    <label for="password">Admin Password</label>
    <input type="password"  name="password" placeholder="Your password..">

	<input type="submit" value="submit">
	<a href="login.jsp">Home</a>
</form>
</div>
</body>
</html>