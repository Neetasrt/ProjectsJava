package com.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	final static String DB_URL="jdbc:mysql://localhost:3306/productdb";
	final static String USER_NAME="root";
	final static String PASSWORD="Neetashukla_25";
	final static String DRIVER="com.mysql.jdbc.Driver";
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER);
		//create a connection with the dB
		Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		if(con!=null) {
			System.out.println("connection is established");
		}
		
		else {
			System.out.println("connection failed");
		}
		
		return con;
	}

}
