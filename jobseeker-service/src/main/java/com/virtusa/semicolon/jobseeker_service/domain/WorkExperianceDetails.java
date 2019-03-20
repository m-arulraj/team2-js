package com.virtusa.semicolon.jobseeker_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="WORK_EXPERIANCE_DETAILS")
public class WorkExperianceDetails {
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="ROLES_AND_RESPONSIBILITIES")
	private String rolesAndResponsibilities;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@Column(name="NUMBER_OF_YEARS")
	private Long numberOfYears;
	
	@Column(name="CURRENT_SALARY")
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

}
