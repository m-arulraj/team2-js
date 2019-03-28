package com.virtusa.semicolon.admin_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_details")
public class Employer {

	@Id
	@Column(name="USERNAME")
	String userName;

	@Column(name="COMPANY_NAME")
	String companyName;

	@Column(name="CONTACT_NUMBER")
	int contactNumber;

	@Column(name="ADDRESS")
	String address;

	@Column(name="ESTABLISHED_ON")
	String establishedOn;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEstablishedOn() {
		return establishedOn;
	}

	public void setEstablishedOn(String establishedOn) {
		this.establishedOn = establishedOn;
	}

}
