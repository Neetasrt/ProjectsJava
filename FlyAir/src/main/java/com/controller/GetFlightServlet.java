package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to.*;

/**
 * Servlet implementation class TestServlet
 */
public class GetFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetFlightServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scity= request.getParameter("scity");
		String dcity= request.getParameter("dcity");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(request.getParameter("fdate"), format);
		int mem= Integer.parseInt(request.getParameter("mem"));
		
		Flyer flyer=new Flyer();
		
		flyer.setScity(scity);
		flyer.setDcity(dcity);
		flyer.setFdate(date);
		flyer.setMem(mem);
		
		Flight flight= new Flight();
		
		List<Flight> flist=null;
		try {
			flist= flight.checkFlight(flyer);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		HttpSession session= request.getSession();
		session.setAttribute("flyerdata", flyer);
		session.setAttribute("flightdata", flist);
		//RequestDispatcher rd= request.getRequestDispatcher("AvailabilityPage.jsp");
		//request.getRequestDispatcher("AvailabilityPage.jsp");
		response.sendRedirect("AvailabilityPage.jsp");
	    /////caller page code
		String caller=(String) session.getAttribute("caller");
		String thepage=request.getRequestURI();
		caller= thepage.substring(thepage.lastIndexOf("/")+1);
		PrintWriter out= response.getWriter();
		out.println(caller);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
