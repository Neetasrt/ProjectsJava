package com.fil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpFilter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to.Admins;
import com.to.Customer;



@WebFilter("/Login")
public class LoginFilter  implements Filter {

    public LoginFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name= request.getParameter("uname");
		String pass= request.getParameter("pwd");
		String categ= request.getParameter("category");
		PrintWriter out= response.getWriter();
		boolean correctlogin=false;
		
		if(name.equals("")|| name==null || pass.equals("")|| pass==null) {
			
			correctlogin=false;
			
		}else {
			
			if(categ.equals("admin")) {
				Admins ad=new Admins();
				List<Admins> al=ad.retrieve();
				
			for(Admins as:al) {
				String amin=as.getUser();
				String pwd= as.getPass();
		
					if(name.equals(amin) && pass.equals(pwd)) {
						correctlogin=true;	
						  
						request.setAttribute("adminlog", as.getUser());//login log created
						chain.doFilter(request, response);
			
					}
				}
			}else
				{
				Customer cs=new Customer();
				List<Customer> al=cs.retrieve();
				for(Customer as:al) {
					String amin=as.getCname();
					String pwd= as.getPass();
			
						if(name.equals(amin) && pass.equals(pwd)) {
							correctlogin=true;	
							request.setAttribute("clog", as.getCname());//login log created
							chain.doFilter(request, response);
				
						}
					}
				
				
				}
			
		}
		if(correctlogin==false) {	
			RequestDispatcher rd=null;
			if(categ.equals("admin")) {
				 rd= request.getRequestDispatcher("adminlogin.jsp");
			}else
			{
				 rd= request.getRequestDispatcher("customerlogin.jsp");
			}
			rd.include(request, response);
			response.setContentType("text/html");
			out.println(" Invalid Username Or Password!!");
			
		}	
		
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
