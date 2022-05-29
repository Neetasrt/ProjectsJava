

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>Product Registration </title>
</head>
<body>

<h1>Product Registration Form</h1>
<br>
<form name=frm method="post" action="ProductServlet">
<table>
<tr><td align="left" width="40%">ProductId</td><td align="center" width="100%"><input type="text" name="id" maxlength=20></td></tr>

<tr><td align="left" >ProductName</td><td align="center" width="100%"><input type="text" name="name"></td></tr>

<tr><td align="left" >Purchased</td><td align="center" width="100%"><input type="number" name="purchase"></td></tr>

<tr><td align="left" width="40%">InStock</td><td align="center" width="100%"><input type="number" name="stock"></td></tr>

<tr><td align="left" width="40%">Price</td><td align="center" width="100%"><input type="number" name="price"></td></tr>
<tr height="30"> <td colspan=2 width="100%"></td> </tr>
</table>
<input type="submit"  value="Submit">


</form>
</body>
</html>