package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.to.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hinow");
		PrintWriter out= response.getWriter();
		if((request.getParameter("name")==null)||(request.getParameter("quantity")==null)||(request.getParameter("price")==null))
			out.println("blank field values.");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		System.out.println("hithen");
		//if((request.getParameter("name")=="")||(request.getParameter("quantity")=="")||(request.getParameter("price")==""))
		//out.println("blank field values.");
		//if(Integer.parseInt(request.getParameter("price"))<0)
		//	out.println("invalid price");
		
		
		Product pr= new Product();
		//pr.setId(1);
		
		out.println(request.getParameter("name"));
		
		pr.setQuantity(Integer.parseInt(request.getParameter("id")));
		pr.setName(request.getParameter("name"));
		pr.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		pr.setPrice(Float.parseFloat(request.getParameter("price")));
		out.println(pr.getId());
		System.out.println(pr.toString());
		ProductDAO pd= new ProductDAO();
		int row=0;
		row=pd.insertRecord(pr);
		System.out.println(row);
		if(row>0) 
			out.println("inserted");
		else
			out.println("none");
			
			
		}
		//doGet(request, response);
	

}
