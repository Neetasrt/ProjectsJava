
<%@ page import="com.bean.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	 
	 <%  Product pr= new Product();
	 HttpSession session1=request.getSession();
	 pr= (Product) session1.getAttribute("sessionId");

	 
	String Id= pr.getProduct_id();
	String name= pr.getProduct_name();
	double purchased= pr.getPurchased();
	double in_stock= pr.getIn_stock();
	float price= pr.getPrice();
	 
	 %>
	 
<table border="1">
<tr><td colspan=2 align="center" ><h3>Product Data as Filled in Form</h3></td></tr>
	<tr><td>	Product Id:	</td><td> <%out.println(Id); %></td></tr>
		<tr><td width="40%">Product Name:</td><td width="40%"><%out.println(name); %></td></tr>
		<tr><td>Purchased:</td><td><%out.println(purchased); %></td></tr>
		<tr><td>In Stock:</td><td><%out.println(in_stock); %></td></tr>
		<tr><td>Price:	</td><td>		<%out.println(price); %></td></tr>
	</table>
	

</body>
</html>