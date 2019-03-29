
package com.virtusa.semicolon.jobseeker_service.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EDUCATIONAL_DETAILS")
public class EducationDetails {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="HIGHEST_DEGREE")
	private String highestDegree;
	
	@Column(name="COLLEGE")
	private String college;
	
	@Column(name="SPECIALIZATION")
	private String specialization;
	
	@Column(name="YEAR_OF_PASSOUT")
	private Long yearOfPassout;
	
	@Column(name="PERCENTAGE")
	private Double percentage;
	
	@Column(name="YEAR_GAP")
	private Long yearGap;
	
	@Column(name="NUMBER_OF_BACKLOGS")
	private Long numberOfBacklogs;
	
	@Column(name="SKILLS")
	private String skills;
	
	/*@Column(name="RESUME")
	private Blob resume;*/

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

/*	public Blob getResume() {
		return resume;
	}

	public void setResume(Blob resume) {
		this.resume = resume;
	}*/
	
	

}
