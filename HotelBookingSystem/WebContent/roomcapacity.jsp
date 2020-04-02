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
<h4>Increase or decrease Room capacity</h4>
<form name="roomcapacity" action="roomcapacity" method="post">

  	<label for="typeofroom">Choose type of room:</label>
  	<select id="typeofroom" name="typeofroom">
    <option value="ST">Standard Type</option>
    <option value="DT">Deluxe Type</option>
    <option value="LT">Luxury Type</option>
  	</select>
  	
	<label for="capacitytochange">Capacity change use (+ or -):</label>
  	<input type="number" name="capacitytochange"  placeholder="Enter a number.."><br><br>
 	<input type="submit" value="Submit">
</form>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Abort and Logout">
</form>
</div>
</body>
</html>