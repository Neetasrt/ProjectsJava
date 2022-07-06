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
<br>
<br>
<h1>Welcome To FlyWay Airlines</h1>
<h2>Customer Information</h2>
<form action="willgotobooking" method="post">
	Name<input type="text" name="uname" max="30"/><br>
	Email<input type="email" name="email" max="30"/><br>
	Phone<input type="number" name="phone" max="30"/><br>
	Password<input type="password" name="pwd"  max="20"/><br>
	Confirm	Password<input type="password" name="cpwd"  max="20"/><br>
			<button>Submit</button>
			
</form>
</body>
</html>