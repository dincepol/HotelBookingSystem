<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Welcome to HBS</title>
</head>
<body>
<div>
<form action="login" method="post" >
	<label for="username">Username</label>
    <input type="text" id="12" name="username" placeholder="Your username..">

    <label for="password">Password</label>
    <input type="password" id="12" name="password" placeholder="Your password..">

<input type="submit" id="13"value="Login"><br/>
<a href="register.jsp">Register Here</a><br/>
<a href="admin.jsp">Admin Login</a><br/>
</form>
</div>
</body>
</html>