package com.virtusa.semicolon.employer_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POSTED_JOBS_LIST")
public class PostedJobsList {
	
	public PostedJobsList(){}
	
	public PostedJobsList(String postedBy, String jobTitle, Long numberOfVacancies, Double salary, String jobId,
			String requiredSkills, String jobDescription,String jobType) {
		this.postedBy = postedBy;
		this.jobTitle = jobTitle;
		this.numberOfVacancies = numberOfVacancies;
		this.salary = salary;
		this.jobId = jobId;
		this.requiredSkills = requiredSkills;
		this.jobDescription = jobDescription;
		this.jobType=jobTitle;
	}
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="POSTED_BY")
	private String postedBy;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="NUMBER_OF_VACANCIES")
	private Long numberOfVacancies;
	
	@Column(name="SALARY")
	private Double salary;
	
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="JOB_TYPE")
	private String jobType;
	
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Column(name="REQUIRED_SKILLS")
	private String requiredSkills;
	
	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;
	
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Long getNumberOfVacancies() {
		return numberOfVacancies;
	}
	public void setNumberOfVacancies(Long numberOfVacancies) {
		this.numberOfVacancies = numberOfVacancies;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


}
