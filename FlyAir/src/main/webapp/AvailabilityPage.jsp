<%@ page import= 'com.to.*' %>
 
<%@ page import ="java.time.LocalDate" %>
<%@ page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<jsp:include page="panel.jsp"></jsp:include>
	<br><br><br><br>
	<h2 align="center">Available Flights</h2>
		
		
<!-- table for available flights -->
<br>
<br>

<% String caller=(String) session.getAttribute("caller");
		String thepage=request.getRequestURI();
		caller= thepage.substring(thepage.lastIndexOf("/")+1);
		%>
caller<%out.println(caller); %>
<%List<Flight> flightlist= (List<Flight>) session.getAttribute("flightdata"); %>
<%Flyer flyerbean=(Flyer) session.getAttribute("flyerdata"); %>

			
			<table border="1" align="center">
				<tr><th>Flight ID</th><th>Airline</th><th>From </th><th>To</th><th>Date</th><th>No. of Travellers</th></tr>
						<%for(Flight f:flightlist){%>
				<tr><td><%out.println(f.getFid()); %></td>
					<td><%out.println(f.getAirname()); %></td>
					<td><%out.println(f.getScity()); %></td>
					<td><%out.println(f.getDcity()); %></td>
					<td><%out.println(f.getDate()); %></td>
					<td><%out.println(flyerbean.getMem()); %></td>
					<td><a href="flightdetails.jsp?fd=<%=f.getFid()%>">BOOK TICKET</a></td>
				</tr>
				<%} %>
			</table>

</body>
</html>