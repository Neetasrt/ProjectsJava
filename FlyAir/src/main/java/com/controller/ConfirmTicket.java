package com.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.to.Tickets;


public class ConfirmTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ConfirmTicket() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long flid= Long.parseLong(request.getParameter("flid"));
		
		//String temp= String.valueOf(request.getParameter("date"));
		//String inputm = input.replace ( " " , "T" );
		String t= request.getParameter("date");
		String tt= t.trim();
		
		LocalDate date= LocalDate.parse(tt);
		//String temp= String.valueOf(dt);
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate date = LocalDate.parse(temp, format);
		
		 String scity= request.getParameter("scity");
		 String dcity= request.getParameter("dcity");
		 String met=request.getParameter("mem").trim();
		 int mem= Integer.parseInt(met);
		 int totalprice=Integer.parseInt(request.getParameter("totalprice"));;
		 String clas= request.getParameter("clas");
		
		Tickets ticket=new Tickets();
		ticket.setFlid(flid);
		ticket.setCsid(2);
		ticket.setDate(date);
		ticket.setScity(scity);
		ticket.setDcity(dcity);
		ticket.setMem(mem);
		ticket.setTotalprice(totalprice);
		ticket.setClas(clas);
		ticket.insert();
		HttpSession session= request.getSession();
		session.setAttribute("confirmticket", ticket);
		response.sendRedirect("printpage.jsp");
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
