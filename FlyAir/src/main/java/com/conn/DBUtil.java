package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	final static String DB_URL="jdbc:mysql://localhost:3306/flyway";
	final static String USER_NAME="root";
	final static String PASSWORD="neeta";
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			//register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//create a connection with the dB
			Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			if(con==null) {
				System.out.println("connection failed");
			}
		return con;
		}
}
