package com.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Product;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		Product pr= new Product();
	//	PrintWriter out= response.getWriter();
		pr.setProduct_id(request.getParameter("id"));
		pr.setProduct_name(request.getParameter("name"));
		pr.setPurchased(Double.parseDouble(request.getParameter("purchase")));
		pr.setIn_stock(Double.parseDouble(request.getParameter("stock")));
		pr.setPrice(Float.parseFloat(request.getParameter("price")));
		response.setContentType("text/html");
		//System.out.println("pr values"+pr.toString());
		session.setAttribute("sessionId", pr);
		response.sendRedirect("display.jsp");
		
		//doGet(request, response);
	}
	
	

}
