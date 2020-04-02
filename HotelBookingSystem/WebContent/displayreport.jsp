<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body>
<table border="2">
<tr>
<td>user ID</td>
<td>Room type</td>
<td>Guests</td>
<td>Arrival Date</td>
<td>Departure Date</td>
</tr> 
<% List username= (List)session.getAttribute("username");
List roomtype= (List)session.getAttribute("roomtype");
List noofguests= (List)session.getAttribute("noofguests");
List arrivaldate= (List)session.getAttribute("arrivaldate");
List departuredate= (List)session.getAttribute("departuredate");
for(int i=0;i<username.size();i++)
{
%>
<tr><td><%=username.get(i)%></td>
<td><%=roomtype.get(i)%></td>
<td><%=noofguests.get(i)%></td>
<td><%=arrivaldate.get(i)%></td>
<td><%=departuredate.get(i)%></td></tr>
<%
}
session.removeAttribute("username");
session.removeAttribute("roomtype");
session.removeAttribute("noofguests");
session.removeAttribute("arrivaldate");
session.removeAttribute("departuredate");
%>
</table>
</body>
</html>