package com.virtusa.semicolon.master.domain;

public class Authorities {

	private Long id;

	private Registration user;

	private String authorities;
	
	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

/*	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + ", user=" + user + ", authorities=" + authorities + "]";
	}

	public Registration getUser() {
		return user;
	}

	public void setUser(Registration user) {
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
