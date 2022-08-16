/**
 * 
 */
package com.example.banking.model;

public class ForgotPassword {

	private String userName;
	private String newPassword;
	private String confirmNewPassword;

	/**
	 * @param userName
	 * @param newPassword
	 * @param confirmNewPassword
	 */
	public ForgotPassword(String userName, String newPassword, String confirmNewPassword) {
		super();
		this.userName = userName;
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
	}

	/**
	 * 
	 */
	public ForgotPassword() {
		super();
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the confirmNewPassword
	 */
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	/**
	 * @param confirmNewPassword the confirmNewPassword to set
	 */
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
