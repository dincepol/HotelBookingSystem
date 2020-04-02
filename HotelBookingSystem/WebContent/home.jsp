<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Welcome Home</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
function getrooms() {
	$(document).ready(function() {
	        $('#submit').click(function(event) {
	                var ad = $('#adate').val();
	                var dd =$('#ddate').val();
	                var tr =$('#typeofroom').val();
	                var ng =$('#noofguests').val();
	                $.post('searchrooms', {
	                        adate : ad,ddate : dd, typeofroom : tr, noofguests : ng
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
String name=(String)session.getAttribute("user");  
out.print("	Hello "+name);  
 %> 
</h4> 
<div class="sr">
<form name="serachrooms" action="javascript:getrooms()">
	<label for="arrivaldate">Arrival Date</label>
  	<input type="date" name="adate" id="adate" ><br><br>

  	<label for="departuredate">Departure Date</label>
  	<input type="date" name="ddate" id="ddate" ><br><br>
  	
  	<label for="typeofroom">Choose type of room:</label>
  	<select id="typeofroom" name="typeofroom">
    <option value="ST">Standard Type</option>
    <option value="DT">Deluxe Type</option>
    <option value="LT">Luxury Type</option>
  	</select>
  	
  	<label for="noofguests">Number of guests:</label>
  	<input type="number" name="noofguests" id="noofguests"  placeholder="Guests.."><br><br>
  	
 	<input type="submit" id="submit" value="Submit">
		
</form>
<form name="logout" action="logout" method="post">
<input type="submit" id="submit" value="Logout">
</form>
</div>
<div class="result" id="ajaxGetUserServletResponse">
<h4>Result:</h4></div>
</body>
</html>