package com.virtusa.semicolon.master.domain;

public class Registration {

	private String userName;

	private String password;
	
	private Long enabled;
	
	

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

	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", password=" + password + ", enabled=" + enabled + "]";
	}

	public Long getEnabled() {
		return enabled;                                                                                                                     
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}


	

	
}
