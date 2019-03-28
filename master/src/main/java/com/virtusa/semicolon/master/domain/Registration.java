package com.virtusa.semicolon.master.domain;

public class Registration {

	private String userName;

	private String password;
<<<<<<< HEAD
	
=======

>>>>>>> cf259f7d83d9df9b2a63bf4bcb622994ae838004
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
