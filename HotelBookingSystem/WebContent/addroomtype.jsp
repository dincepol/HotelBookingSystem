<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>HBS</title>
</head>
<body>
<div>
<h4>Add Room Type</h4>
<form name="addroomtype" action="addroomtype" method="post">

  	<label for="typeofroom">Choose type of room:</label>
  	<select id="typeofroom" name="typeofroom">
    <option value="ST">Standard Type</option>
    <option value="DT">Deluxe Type</option>
    <option value="LT">Luxury Type</option>
  	</select>
	<label for="roomstoadd">Rooms to add</label>
  	<input type="number" name="roomstoadd" ><br><br>
 	<input type="submit" value="Submit">
</form>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Abort and Logout">
</form>
</div>
</body>
</html>