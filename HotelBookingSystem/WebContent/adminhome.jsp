<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<%    
String name=(String)session.getAttribute("adminuser");  
out.print("Hello Admin "+name);  
 %>
<title>HBS</title>
</head>
<body>
<div>
<h4>What you want to do ?</h4>
<button onclick="window.location.href= 'addroomtype.jsp';">Add Room Type</button>
<button onclick="window.location.href= 'roomcapacity.jsp';">Increase or decrease Room capacity</button>
<button onclick="window.location.href= 'report.jsp';">Generate Report</button>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Logout">
</form>
</div>
</body>
</html>