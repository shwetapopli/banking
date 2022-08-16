package com.example.banking.model;

public class Login {

	private String username;
	private String password;
	private String loginid;
	private String confirmPassword;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private String custId;
	private int accountNumber;
	private String sinNumber;

	/**
	 * @param username
	 * @param password
	 * @param loginid
	 * @param confirmPassword
	 * @param email
	 * @param phone
	 * @param firstName
	 * @param lastName
	 * @param custId
	 * @param accountNumber
	 * @param sinNumber
	 */
	public Login(String username, String password, String loginid, String confirmPassword, String email, String phone,
			String firstName, String lastName, String custId, int accountNumber, String sinNumber) {
		super();
		this.username = username;
		this.password = password;
		this.loginid = loginid;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.custId = custId;
		this.accountNumber = accountNumber;
		this.sinNumber = sinNumber;
	}

	/**
	 * 
	 */
	public Login() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}

	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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