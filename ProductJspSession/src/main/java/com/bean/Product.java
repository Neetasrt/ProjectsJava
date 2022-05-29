package com.bean;

public class Product {
	
	String product_id;
	String product_name;
	double purchased;
	double in_stock;
	float price;
	
	public Product() {
		
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPurchased() {
		return purchased;
	}
	public void setPurchased(double purchased) {
		this.purchased = purchased;
	}
	public double getIn_stock() {
		return in_stock;
	}
	public void setIn_stock(double in_stock) {
		this.in_stock = in_stock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	 public String toString() {
		 return(product_id+""+product_name+""+purchased+""+in_stock+""+price);
	 }
	
	}
	

	


