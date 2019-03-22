package com.virtusa.semicolon.registration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name="USERNAME")
	private Registration user;
	/*@Column(name="USERNAME")
	private String userName;
*/	
	@Column(name = "AUTHORITIES")
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
