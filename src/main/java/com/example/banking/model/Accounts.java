package com.example.banking.model;

public class Accounts {

	private int Account_number;
	private int Account_Type_ID;
	private String Cust_ID;
	private String Balance;
	private String username;
	private String custid;
	private String targetCustId;
	private String f_name;
	private String l_name;
	private String dueAmount;
	
	public int getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	public int getAccount_Type_ID() {
		return Account_Type_ID;
	}
	public void setAccount_Type_ID(int account_Type_ID) {
		Account_Type_ID = account_Type_ID;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getBalance() {
		return Balance;
	}
	public void setBalance(String balance) {
		Balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getTargetCustId() {
		return targetCustId;
	}
	public void setTargetCustId(String targetCustId) {
		this.targetCustId = targetCustId;
	}
	
	
}
