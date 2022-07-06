package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.DBUtil;
import com.to.*;

public class FlightClassdao {

	DBUtil dbu= new DBUtil();
	private Connection con=null;
public void insert() {
	int row=0;
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	String sqlp="insert into fclass(flightid, clas, fare) values(?,?,?)";
	
	PreparedStatement ps=null;
	try {
		ps = con.prepareStatement(sqlp);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		ps.setLong(1, getFlightid());
		ps.setString(2, getClas());
		ps.setInt(3, getPrice());
		
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
public List<Fclass> retrieve(long flid) throws SQLException{
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	ResultSet rsp=null;
	ArrayList<Fclass> list= new ArrayList<>();
	String sql1="select  * from fclass where flightid=?";
	//prepared statement
	PreparedStatement ps=null;
	
		ps = con.prepareStatement(sql1);
			ps.setLong(1, flid);///it should be flid here
			rsp= ps.executeQuery();
		 
	while(rsp.next()) {
		Fclass fc= new Fclass();
		fc.setId(Integer.parseInt(rsp.getString(1)));
		fc.setFlightid(Long.parseLong(rsp.getString(2)));
		fc.setClas(rsp.getString(3));
		fc.setPrice(Integer.parseInt(rsp.getString(4)));
		list.add(fc);
		}
		con.close();
		
		return list;
	
}

public Fclass retclas(int cid) throws SQLException{
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	ResultSet rsp=null;
	
	String sql1="select  * from fclass where id=?";
	
	PreparedStatement ps=null;
	
		ps = con.prepareStatement(sql1);
			ps.setInt(1, cid);
			rsp= ps.executeQuery();
			
			Fclass fc= new Fclass();
	while(rsp.next()) {
		fc.setId(Integer.parseInt(rsp.getString(1)));
		fc.setFlightid(Long.parseLong(rsp.getString(2)));
		fc.setClas(rsp.getString(3));
		fc.setPrice(Integer.parseInt(rsp.getString(4)));;
				
	}	
	con.close();
		return fc;
	
}


}
