package com.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Product;
import com.dao.*;

public class GetProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("product_id");
		PrintWriter out= response.getWriter();
		Product st=new Product();
		ProductDAO std=new ProductDAO();
		ResultSet rsp=null;
		
		try {
			rsp= std.searchIt(st,id);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
				response.setContentType("text/html");
		int count=0;
		try {
			while(rsp.next()) {
				
				out.println("\t\t\t\tProduct Details\n");
				out.println("\tProduct_Id\tProduct_name\tPurchased Quantity\tIn Stock\tPrice");
				
				out.println("\t"+rsp.getString(1)+"\t\t"+ rsp.getString(2)+ "\t\t"+ rsp.getDouble(3)+"\t\t"+ rsp.getDouble(4)+ "\t\t"+rsp.getFloat(5));
				
				/*out.println("<html><body><table border=\"1\">");
				out.println("<tr valign=\"middle\"><td align=\"center\" width=\"20%%\"> Product details</td></tr>");
				out.println("<tr valign=\"middle\"><td align=\"center\" width=\"20%\">"+ rsp.getString(1)+ "</td><td align=\"center\" width=\"20%\">"+ rsp.getString(2)+ "</td><td align=\"center\" width=\"20%\">"+ rsp.getDouble(3)+"</td><td align=\"center\" width=\"20%\">"+ rsp.getDouble(4)+ "</td><td align=\"center\" width=\"20%\">"+rsp.getFloat(5)+"</td></tr>");
				out.println("</table></body></html>");*/
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(count==0)
			out.println("Product Record Not Found");
				
		}
		
	}


