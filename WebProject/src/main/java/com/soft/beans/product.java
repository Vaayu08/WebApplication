package com.soft.beans;

import java.io.Serializable;

public class product implements Serializable{
 
	private int pid;
	private String pname;
	private int pqty;
	private double pprice;
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(int pid, String pname, int pqty, double pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pqty = pqty;
		this.pprice = pprice;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	
}
