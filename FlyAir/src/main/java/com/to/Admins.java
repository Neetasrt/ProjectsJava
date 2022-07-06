package com.to;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conn.DBUtil;

public class Admins {
	private int id;
	private String user;
	private String pass;
	private String newpass;

private Connection con=null;

public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getNewpass() {
	return newpass;
}
public void setNewpass(String newpass) {
	
	this.newpass = newpass;
	
}


DBUtil dbu= new DBUtil();

public void addAdmin() {
	int row=0;
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	String sqlp="insert into admins(name, password) values(?,?)";
	
	PreparedStatement ps=null;
	try {
		ps = con.prepareStatement(sqlp);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		ps.setString(1, getUser());
		ps.setString(2, getPass());
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



public void changePass() {
	
	int row=0;
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	String sqlp="update admins set password=(?) where name=(?)";
	
	PreparedStatement ps=null;
	
	
	try {
		ps = con.prepareStatement(sqlp);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		ps.setString(1, getNewpass());
		ps.setString(2, getUser());
		} catch (SQLException e) {
		e.printStackTrace();
	}

	try {
		row=ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	if (row>0)
		System.out.println("Success");
	else
		System.out.println("Failure");
	
	try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}


public List<Admins> retrieve()  {
	try {
		con= dbu.getConnection();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	ResultSet rsp=null;
	ArrayList<Admins> list= new ArrayList<>();
	String sql1="select  * from admins";
	
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
			Admins ad= new Admins();
			ad.setUser(rsp.getString(2));
			ad.setPass(rsp.getString(3));
			
			list.add(ad);
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
