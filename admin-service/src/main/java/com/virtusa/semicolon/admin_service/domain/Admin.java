package com.virtusa.semicolon.admin_service.domain;

import javax.persistence.Column;

public class Admin {

	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	
}
