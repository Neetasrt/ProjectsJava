package com.dao;

import com.conn.ConnHiber;
import com.to.Product;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {
	
	public int insertRecord(Product p) {
	ConnHiber conn= new ConnHiber();
	Session session= conn.conHib();
	
	if(session!=null) {
		System.out.println("connected");}
	else {
		System.out.println("error");}
	
	Transaction tr=session.beginTransaction();
	
	int rowId=0;
	rowId= (int)session.save(p);
	tr.commit();
	//session.close();
	return rowId;
	
	}
	
}
