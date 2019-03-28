package com.virtusa.semicolon.master.domain;

<<<<<<< HEAD
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


>>>>>>> cf259f7d83d9df9b2a63bf4bcb622994ae838004
public class WorkExperianceDetails {
	

	private Long id;
<<<<<<< HEAD
=======
	
>>>>>>> cf259f7d83d9df9b2a63bf4bcb622994ae838004

	private String userName;

	private String companyName;
<<<<<<< HEAD
	
	private String designation;
	
	private String rolesAndResponsibilities;
	
	private String startDate;
=======

	private String designation;
	

	private String rolesAndResponsibilities;

	private String startDate;
	
>>>>>>> cf259f7d83d9df9b2a63bf4bcb622994ae838004

	private String endDate;

	private Long numberOfYears;

	private Double currentSalary;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRolesAndResponsibilities() {
		return rolesAndResponsibilities;
	}

	public void setRolesAndResponsibilities(String rolesAndResponsibilities) {
		this.rolesAndResponsibilities = rolesAndResponsibilities;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(Long numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
