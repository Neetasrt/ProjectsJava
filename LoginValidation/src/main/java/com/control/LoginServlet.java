package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		PrintWriter out=response.getWriter();
		String user= request.getParameter("uname");
		String pass=request.getParameter("pwd");
		
		if(user.equals("admin") && pass.equals("1234")) {
		session.setAttribute("user", user);
		response.sendRedirect("DashBoard");
		}else {
		
		//if(user.contentEquals("") || pass.contentEquals("")) {// || user.contentEquals(null) || pass.contentEquals(null)) {
			out.println("Incorrect credentials<br><br>");
			response.setContentType("text/html");
			out.println("<html>"
					+ "<body>"
					+ "<a href= 'login.html' >TryAgain</a><br>"
					+ "</body>"
					+ "</html>");
		}
	}
	
}
