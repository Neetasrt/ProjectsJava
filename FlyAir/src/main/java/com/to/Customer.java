package com.to;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.DBUtil;

public class Customer {
	private long id;
	private String cname;
	private String cmail;
	private int cphone;
	private String pass;
	
	private Connection con=null;
	DBUtil dbu= new DBUtil();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
	}
	public int getCphone() {
		return cphone;
	}
	public void setCphone(int cphone) {
		this.cphone = cphone;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	//to register customer
	
	public void insert() {
		int row=0;
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sqlp="insert into customer( name, email, phone, password) values(?,?,?,?)";
		
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(sqlp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.setString(1, getCname());
			ps.setString(2, getCmail());
			ps.setInt(3, getCphone());
			ps.setString(4, getPass());		
			
			
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
	
//login customer/retrieve customer details
	
	public List<Customer> retrieve()  {
		try {
			con= dbu.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		ResultSet rsp=null;
		ArrayList<Customer> list= new ArrayList<>();
		String sql1="select  * from customer";
		
		//prepared statement
		
		PreparedStatement ps=null;
		
			try {
				ps = con.prepareStatement(sql1);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			 try {
				rsp= ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		try {
			while(rsp.next()) {
				Customer cs= new Customer();
				cs.setCname(rsp.getString(2));
				cs.setCmail(rsp.getString(3));
				cs.setCphone(Integer.parseInt(rsp.getString(4)));
				cs.setPass(rsp.getString(5));
				
				list.add(cs);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;

	}
	
	
	
}
