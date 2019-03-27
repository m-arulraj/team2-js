package com.virtusa.semicolon.master.domain;

public class FeedBack {

	
	private Long id;

	
	private String userName;


	private Long jobId;

	
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", userName=" + userName + ", jobId=" + jobId + ", message=" + message + "]";
	}
}
