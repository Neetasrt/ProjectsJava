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

<!--  String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);HttpContext.Current.Request.ServerVariables("HTTP_REFERER")-->
<% String caller="flightdetails.jsp";//(String)session.getAttribute("caller");
	

%>
caller<%out.println(caller); %>
<h1>Login to Proceed to Booking</h1>
<form action="<%=caller %>" method="post">
	Name<input type="text" name="uname" max="30"/><br>
	Password<input type="password" name="pwd"  max="20"/><br>
			<button>Login</button>
			
</form>

<%String name= request.getParameter("uname");
pageContext.setAttribute("user",name,PageContext.SESSION_SCOPE);

%>

</body>
</html>