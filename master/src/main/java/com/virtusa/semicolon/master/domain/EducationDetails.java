
package com.virtusa.semicolon.master.domain;

import java.sql.Blob;

<<<<<<< HEAD
public class EducationDetails {
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class EducationDetails {
	
>>>>>>> cf259f7d83d9df9b2a63bf4bcb622994ae838004

	private Long id;

	private String userName;

	private String highestDegree;

	private String college;

	private String specialization;

	private Long yearOfPassout;

	private Double percentage;

	private Long yearGap;

	private Long numberOfBacklogs;

	private String skills;

	private Blob resume;

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

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Long getYearOfPassout() {
		return yearOfPassout;
	}

	public void setYearOfPassout(Long yearOfPassout) {
		this.yearOfPassout = yearOfPassout;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Long getYearGap() {
		return yearGap;
	}

	public void setYearGap(Long yearGap) {
		this.yearGap = yearGap;
	}

	public Long getNumberOfBacklogs() {
		return numberOfBacklogs;
	}

	public void setNumberOfBacklogs(Long numberOfBacklogs) {
		this.numberOfBacklogs = numberOfBacklogs;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Blob getResume() {
		return resume;
	}

	public void setResume(Blob resume) {
		this.resume = resume;
	}
	
	

}
