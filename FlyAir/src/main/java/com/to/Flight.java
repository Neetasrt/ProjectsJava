package com.to;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.conn.DBUtil;

public class Flight {
	
	private long fid;
	private String airname;
	private int capcity;
	private int buked;
	private LocalDate date;
	private String scity;
	private String dcity;
	
		
	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getAirname() {
		return airname;
	}

	public void setAirname(String airname) {
		this.airname = airname;
	}

	public int getCapcity() {
		return capcity;
	}

	public void setCapcity(int capcity) {
		this.capcity = capcity;
	}

	public int getBuked() {
		return buked;
	}

	public void setBuked(int booked) {
		this.buked = booked;
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

	
	DBUtil dbu= new DBUtil();
	private Connection con=null;
	
	
	//insert data into flight table
	public void insert() {
		int row=0;
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sqlp="insert into flight( airline, capacity, booked, fdate, sport, dport) values(?,?,?,?,?,?)";
		
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(sqlp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.setString(1, getAirname());
			ps.setInt(2, getCapcity());
			ps.setInt(3, getBuked());
			
			java.sql.Date sd= java.sql.Date.valueOf(getDate());
			ps.setDate(4, sd);
			ps.setString(5, getScity());		
			ps.setString(6, getDcity());
			
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
	
	
	
	//get available flights for customer search
	public List<Flight> checkFlight(Flyer flyer) throws SQLException {
		int row=0;
		ResultSet rsp=null;
		ArrayList<Flight> list= new ArrayList<>();
		
		
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
		
		String sql1="select * from flight where (capacity-booked)>=?  HAVING( dport=? and sport=? and fdate>=?)";
		//select flight.fl_id, airline.ar_name, flight.scity, flight.dcity from flight where (capacity-booked)>=15 HAVING( dcity='mumbai and scity='delhi' and fdate>='2022-05-01' and v_status=1)inner join airline on flight.ar_id= airline.ar_id;
		PreparedStatement ps=null;
		
		ps = con.prepareStatement(sql1);
				ps.setInt(1,flyer.getMem());
				ps.setString(2, flyer.getDcity());
				ps.setString(3, flyer.getScity());
				java.sql.Date sd= java.sql.Date.valueOf(flyer.getFdate());
				ps.setDate(4, sd);

				rsp= ps.executeQuery();
		 
					while(rsp.next()) {
						Flight fl= new Flight();
						fl.setFid(Long.parseLong(rsp.getString(1))); 
						fl.setAirname(rsp.getString(2));
						fl.setCapcity(Integer.parseInt(rsp.getString(3)));
						fl.setBuked(Integer.parseInt(rsp.getString(4)));
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						fl.setDate(LocalDate.parse(rsp.getString(5), format));
						fl.setScity(rsp.getString(6));
						fl.setDcity(rsp.getString(7));
						
						list.add(fl);
	}
	con.close();
	return list;
		
	}
	
	
	public Flight retrieve(long flid) throws SQLException{
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		ResultSet rsp=null;
		ArrayList<Flight> list= new ArrayList<>();
		String sql1="select  * from flight where id=?";
		//prepared statement
		PreparedStatement ps=null;
		
			ps = con.prepareStatement(sql1);
				ps.setLong(1, flid);
				rsp= ps.executeQuery();
				
				Flight fl= new Flight();
		while(rsp.next()) {
			
			fl.setFid(Long.parseLong(rsp.getString(1))); 
			fl.setAirname(rsp.getString(2));
			fl.setCapcity(Integer.parseInt(rsp.getString(3)));
			fl.setBuked(Integer.parseInt(rsp.getString(4)));
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			fl.setDate(LocalDate.parse(rsp.getString(5), format));
			fl.setScity(rsp.getString(6));
			fl.setDcity(rsp.getString(7));
			
			//list.add(fl);
		
			
		}	
		con.close();
			return fl;
		
	}
	
	
}
