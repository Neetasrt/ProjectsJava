 
<%@ page import= 'com.to.Flyer' %>
<%@ page import ="java.time.LocalDate" %>
<%@ page import= "java.time.format.DateTimeFormatter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyWay Services</title>
</head>
<body>
<jsp:include page="panel.jsp"></jsp:include>
<br><br><br>
<h1 align="center">Plan Your Fly</h1>


<form action="GetFlightServlet" method="post">
	<table align="center" width="50%">
<tr ><td >From</td><td><select id="scity" name="scity" width=50>
 			 <option value="Delhi">Delhi</option>
 			 <option value="Mumbai">Mumbai</option>
 			 <option value="Chennai">Chennai</option>
 			 <option value="Bengaluru">Benagaluru</option>
			</select></td>

		
<td>To</td><td><select id="dcity" name="dcity" width=50>
  			<option value="Delhi">Delhi</option>
  			<option value="Mumbai">Mumbai</option>
  			<option value="Chennai">Chennai</option>
  			<option value="Bengaluru">Benagaluru</option>
			</select></td></tr>
			<tr ></tr>
			<tr ></tr>
<tr ><td >FlyDate</td><td><input type="date" id="fdate" name="fdate" /></td></tr>
<tr ></tr>
<tr ></tr>
			
<tr ><td> No. of Travellers</td><td colspan=3 ><input list="members" name="mem" id="mem" size="10">
 		 <datalist id="members">
  		 <option value="1">
    	 <option value="2">
    	 <option value="3">
     	 <option value="4">
     	 <option value="5">
  		</datalist></td></tr>
 <tr ></tr>
<tr ></tr>
<tr align="center"><td colspan=4><input type="submit" value="Get Available Flights" name="getflights" /></td></tr>
</table>
</form>
        	   
</body>
</html>