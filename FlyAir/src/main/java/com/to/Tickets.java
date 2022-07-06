package com.to;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.conn.DBUtil;

public class Tickets {
private long id;
private long flid;
private long csid;
private LocalDate date;
private String scity;
private String dcity;
private int mem;
private int totalprice;
//new adds
private String clas;
//private String airname;

public String getClas() {
	return clas;
}
public void setClas(String clas) {
	this.clas = clas;
}

private Connection con=null;
DBUtil dbu= new DBUtil();



public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getFlid() {
	return flid;
}
public void setFlid(long flid) {
	this.flid = flid;
}
public long getCsid() {
	return csid;
}
public void setCsid(long csid) {
	this.csid = csid;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getScity() {
	return scity;
}
public void setScity(String scity) {
	this.scity = scity;
}
public String getDcity() {
	return dcity;
}
public void setDcity(String dcity) {
	this.dcity = dcity;
}
public int getMem() {
	return mem;
}
public void setMem(int mem) {
	this.mem = mem;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

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
