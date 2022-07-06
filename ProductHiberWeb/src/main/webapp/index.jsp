<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product Registration Form</h1>
<br>
<form name=frm method="post" action="ProductServlet">
<table>
<tr><td align="left" width="40%">Product Id</td><td align="center" width="100%"><input type="text" name="id" maxlength=20></td></tr>

<tr><td align="left" width="40%">Product Name</td><td align="center" width="100%"><input type="text" name="name" maxlength=20></td></tr>

<tr><td align="left" >Quantity</td><td align="center" width="100%"><input type="number" name="quantity"></td></tr>

<tr><td align="left" >Price</td><td align="center" width="100%"><input type="number" name="price"></td></tr>
</table>
<input type="submit"  value="Submit">


</form>
</body>
</html>