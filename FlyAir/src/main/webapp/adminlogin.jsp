<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<jsp:include page="panel.jsp"></jsp:include>
<br>
<br>
<h1>Welcome To Admin Page</h1>
<form action="adminpage" method="post">
	UserName<input type="text" name="uname" max="30"/><br>
	Password<input type="password" name="pwd"  max="20"/><br>
	<input type="hidden" name="category" value="admin"/>
			<button>Login</button>
</form>
</body>
</html>