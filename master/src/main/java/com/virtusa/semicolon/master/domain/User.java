package com.virtusa.semicolon.master.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="users")
public class User {
	
	public User()
	{
		super();
	}
	
	public User(String userName, String password, Long enabled) {
	
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	@Id
	@Column(name="USERNAME")
	String userName;
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", enabled=" + enabled + "]";
	}

	@Column(name="PASSWORD")
	String password;
	
	@Column(name="ENABLED")
	Long enabled;
	

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
