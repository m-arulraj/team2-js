package com.virtusa.semicolon.registration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Registration {
	
	@Id
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ENABLED")
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
