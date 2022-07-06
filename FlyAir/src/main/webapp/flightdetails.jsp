<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= 'com.to.*' %>
    <%@ page import ="java.util.List" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  //=(String)session.getAttribute("user"); %>-->

<% String caller=(String) session.getAttribute("caller");
		String thepage=request.getRequestURI();
		caller= thepage.substring(thepage.lastIndexOf("/")+1);
		%>
		caller<%out.println(caller); %>
<%String clog="neet";%>
<jsp:include page="panel.jsp"></jsp:include>
	<br><br><br><br>
	<h2 align="center">Flight Details</h2>
<form>



		<%Long tfid= Long.parseLong(request.getParameter("fd"));%>

<jsp:useBean id="flt" class="com.to.Flight" scope="session"></jsp:useBean>
				<%Flight f=flt.retrieve(tfid); %>
<jsp:useBean id="fclas" class="com.to.Fclass" scope="session"></jsp:useBean>
				<% List<Fclass> classlist= fclas.retrieve(tfid); %>
<table border="1" align="center">
				<tr><th>Flight No</th><th>Airline</th><th>Class </th><th>Fare</th></tr>
						<%for(Fclass fc:classlist){%>
				<tr><td><%out.println(f.getFid()); %></td>
					<td><%out.println(f.getAirname()); %></td>
					<td><%out.println(fc.getClas()); %></td>
					<td><%out.println(fc.getPrice()); %></td>
					
				<!-- how to set attri for current instance -->
				<!--  	<%//session.setAttribute("classdetails", fc); %>--> 
				
				<%if(clog.equals("neet")){%>  <!-- //|| clog.equals("")){%> -->
					<td><a href="ticketspage.jsp?cid=<%=fc.getId()%>">BOOK TICKET</a></td>
					<%} %>
				</tr>
				<%} %>
</table>
<br><br><br>
			<%if(!clog.equals("neet")){%>
				<table align="center">
				<tr><td colspan=2 >YOU Need to login to Proceed with Booking</td></tr>
				</table>
				
				<%} %>
				<!--  //out.println("YOU Need to login to Proceed Booking"); }%>-->
				
</form>

</body>
</html>