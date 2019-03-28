package com.virtusa.semicolon.admin_service.domain;

public class UpdateUser {

	private String userName;
	private String password;
	private String newPassword;
	private String newUserName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	@Override
	public String toString() {
		return "UpdateUser [userName=" + userName + ", password=" + password + ", newPassword=" + newPassword
				+ ", newUserName=" + newUserName + "]";
	}
	
	
	
	
}
