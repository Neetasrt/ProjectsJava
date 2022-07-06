package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBUtil;
import com.to.*;
public class Ticketsdao {
	
	DBUtil dbu= new DBUtil();
	private Connection con=null;
	//save tickets booked
	public void insert() {
		int row=0;
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sqlp="insert into ticket( flightid, customerid, fdate, sport, dport, travellers, totalfare, clas) values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=null;// /*
		try {
			ps = con.prepareStatement(sqlp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.setLong(1, getFlid());
			ps.setLong(2, getCsid());
			java.sql.Date sd= java.sql.Date.valueOf(getDate());
			ps.setDate(3, sd);
			ps.setString(4, getScity());		
			ps.setString(5, getDcity());
			ps.setInt(6, getMem());
			ps.setInt(7, getTotalprice());
			ps.setString(8, getClas());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		
	}


}
