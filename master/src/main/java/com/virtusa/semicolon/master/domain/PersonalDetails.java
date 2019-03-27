package com.virtusa.semicolon.master.domain;

public class PersonalDetails {

	
	private Long id;
	

	private String userName;


	private String firstName;
	

	private String lastName;
	

	private String gender;
	

	private Long contactNumber;
	

	private String dateOfBirth;
	

	private String address;
	

	private String fatherName;
	

	private String country;
	

	private String state;
	

	private Long pincode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth2) {
		this.dateOfBirth = dateOfBirth2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", contactNumber=" + contactNumber + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", fatherName=" + fatherName + ", country=" + country + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
}
