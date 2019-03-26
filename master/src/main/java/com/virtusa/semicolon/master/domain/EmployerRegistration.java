package com.virtusa.semicolon.master.domain;

public class EmployerRegistration {

	private String userName;
	
	private String password;
	
	private Long enabled;
	
	
	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getEnabled() {
		return enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	
	@Override
	public String toString() {
		return "EmployerRegistration [userName=" + userName + ", password=" + password + ", enabled=" + enabled
				+"]";
	}
}
