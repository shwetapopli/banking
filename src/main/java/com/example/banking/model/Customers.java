package com.example.banking.model;

import java.sql.Date;

public class Customers {

	private String Cust_ID;
	private String f_name;
	private String l_name;
	private String city;
	private String mobile_no;
	private Date dob;
	private String address;
	private String username;
	private String password;
	private String isAdmin;
	private Integer dueAmount;
	private String sinNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCust_ID() {
		return Cust_ID;
	}

	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Integer dueAmount) {
		this.dueAmount = dueAmount;
	}

	/**
	 * @return the sinNumber
	 */
	public String getSinNumber() {
		return sinNumber;
	}

	/**
	 * @param sinNumber the sinNumber to set
	 */
	public void setSinNumber(String sinNumber) {
		this.sinNumber = sinNumber;
	}

}
