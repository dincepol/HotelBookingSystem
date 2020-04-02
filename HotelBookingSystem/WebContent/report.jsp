
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Report Generator</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
function report() {
	$(document).ready(function() {
	        $('#submit').click(function(event) {
	                var r = $('#generatereport').val();
	                var d =$('#date').val();
	                $.post('report', {
	                        generatereport : r,date : d
	                }, function(data) {
	                        $('#ajaxGetUserServletResponse').html(data);
	                });
	        });
		});
	}</script>
</head>
<body>
<h4>
<%    
String name=(String)session.getAttribute("adminuser");  
out.print("	Hello "+name);  
 %> 
</h4> 
<div>
<h4>Report for :</h4>
<form name="serachrooms" action="javascript:report()">

	<label for="generatereport">Choose type of report:</label>
  	<select id="generatereport" name="generatereport">
    <option value="FA">For all days</option>
    <option value="FD">For a day</option>
  	</select>
  	<label for="date">Enter date(YYYY-MM-DD):</label>
  	<input type="date" name="date" id="date" ><br><br>
<input type="submit" id="submit" value="GetReport">	
</form>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Abort and Logout">
</form>
</div>
<div class="result" id="ajaxGetUserServletResponse">
<h4>Result:</h4></div>

</body>
</html>