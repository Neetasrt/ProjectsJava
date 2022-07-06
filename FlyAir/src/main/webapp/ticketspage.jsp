<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= 'com.to.*' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="panelc.jsp"></jsp:include>
<br>
<br>

<form action="ConfirmTicket" method="post">

<table align="center" >
<%Flyer flyer= (Flyer)session.getAttribute("flyerdata"); %>
<%//not working Fclass fclass= (Fclass)session.getAttribute("classdetails"); %>

<%int tcid= Integer.parseInt(request.getParameter("cid"));%>

    <jsp:useBean id="cst" class="com.to.Customer"></jsp:useBean>
    <jsp:useBean id="fclass" class="com.to.Fclass"></jsp:useBean>
    	<%Fclass fc=fclass.retclas(tcid); %>
    
	<jsp:useBean id="flt" class="com.to.Flight"></jsp:useBean>
			<%Flight fl=flt.retrieve(fc.getFlightid()); %>
							
	
	

	<tr><td colspan=2 align="center">Travel Details</td></tr>
	<tr><td colspan=2 align="center"></td></tr>
	<tr><td colspan=2 align="center"></td></tr>
	<tr><td>Flight Number</td><td><input type="text" name="flid" value="<%=fl.getFid()%>" /></td></tr>
	<tr><td>Airline</td><td><input type="text" name="airname" value="<%=fl.getAirname() %> " readonly/></td></tr>
	<!-- removed from here -->
	<tr><td>Travel Class</td><td><input type="text" name="clas"  value="<%=fc.getClas() %> "readonly /></td></tr>
	<!-- customer id remains -->
	<tr><td>Source </td><td><input type="text" name="scity" value="<%=fl.getScity() %> " readonly/></td></tr>
	<tr><td>Destination</td><td><input type="text" name="dcity" value="<%=fl.getDcity() %> " readonly/></td></tr>
	<tr><td>Date of Travel</td><td><input type="text" name="date"  value="<%=fl.getDate() %> " readonly/></td></tr>
	<tr><td>Number Of Travellers</td><td><input type="text" name="mem" value="<%=flyer.getMem() %> "/></td></tr>
	<tr><td>Total Fare</td><td><input type="text" name="totalprice" value="<%=fc.getPrice()* flyer.getMem()%>" readonly/></td></tr>
	<tr><td colspan=2 align="center"></td></tr>
	<tr><td colspan=2 align="center"></td></tr>
	<tr><td colspan=2 align="center"><input type="submit" value="Confirm Ticket" name="confirm"/></td></tr>
	
	</table>
</form>
	

	
	

	
</body>
</html>