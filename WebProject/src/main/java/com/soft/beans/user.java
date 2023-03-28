package com.soft.beans;

import java.io.Serializable;



public class user implements Serializable{

	private int userId;
	private String userName;
	private String userEmail;
	private String password;
	private int contactNumber;
	private String address;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(int userId, String userName, String userEmail, String password, int contactNumber, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
		
	
}
