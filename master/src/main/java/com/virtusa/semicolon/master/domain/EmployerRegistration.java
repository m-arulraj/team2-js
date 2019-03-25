package com.virtusa.semicolon.master.domain;

public class EmployerRegistration {

	private String userName;
	
	private String password;
	
	private Long enabled;
	
	private String authorities;

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

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "EmployerRegistration [userName=" + userName + ", password=" + password + ", enabled=" + enabled
				+ ", authorities=" + authorities + "]";
	}
}
