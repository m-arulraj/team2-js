package com.virtusa.semicolon.employer_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_DETAILS")
public class CompanyDetails {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ESTABLISHED_ON")
	private String establishedOn;

	public CompanyDetails() {
	}

	public CompanyDetails(String companyName, Long contactNumber, String address, String establishedOn) {

		this.companyName = companyName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.establishedOn = establishedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
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
