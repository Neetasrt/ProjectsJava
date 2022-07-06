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

<h1>FLYWAY AIR</h1><br>
<h3>You are successfully Logged out</h3><br>
<%session.invalidate(); 
%>

</body>
</html>