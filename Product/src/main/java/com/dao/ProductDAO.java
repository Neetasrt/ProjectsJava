package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Product;
import com.dbUtil.DBUtil;

public class ProductDAO {
	DBUtil dbu=new DBUtil();
	
	
public ResultSet searchIt(Product st, String id) throws ClassNotFoundException, SQLException {
	Scanner sc= new Scanner(System.in);
	Connection con= dbu.getConnection();
	String sql1="select  * from product_details where product_id= ?";
	
	//prepared statement
	
	PreparedStatement ps=con.prepareStatement(sql1);
	ps.setString(1, id);
	ResultSet rsp=ps.executeQuery(); //object of rs we have the address of the table
	return rsp;
	}
}