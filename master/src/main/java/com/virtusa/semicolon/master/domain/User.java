package com.virtusa.semicolon.master.domain;

public class User {

	public User() {
		super();
	}

	public User(String userName, String password, Long enabled) {

		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	String userName;
	String newUserName;
	String password;
	String newPassword;
	Long enabled;

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", newUserName=" + newUserName + ", password=" + password
				+ ", newPassword=" + newPassword + ", enabled=" + enabled + "]";
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Long getEnabled() {
		return enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

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

}
