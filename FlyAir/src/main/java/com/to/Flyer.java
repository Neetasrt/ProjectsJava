package com.to;

import java.io.Serializable;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.time.LocalDate;

public class Flyer implements Serializable{
	
private String scity;
private String dcity;
private LocalDate fdate;
private int mem;


public Flyer() {
	
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

public LocalDate getFdate() {
	return fdate;
}

public void setFdate(LocalDate fdate) {
	this.fdate = fdate;
}


public String toString() {
	
return (scity+ " " + dcity+ " " +mem+ " "+fdate);	
}



}

