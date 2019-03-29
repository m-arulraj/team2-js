package com.virtusa.semicolon.master.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.semicolon.master.domain.EducationDetails;
import com.virtusa.semicolon.master.domain.FeedBack;
import com.virtusa.semicolon.master.domain.PersonalDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.domain.WorkExperianceDetails;
import com.virtusa.semicolon.master.util.EndPointConstant;

@Service
public class JobSeekerService {
	
RestTemplate template = new RestTemplate();

	

	public List<PostedJobsList> getListOfJobs(String uri) {
		ResponseEntity<List<PostedJobsList>> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<PostedJobsList>>() {
				});
		return response.getBody();

	}



	public PersonalDetails getPersonalDetails(String uri) {
		ResponseEntity<PersonalDetails> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<PersonalDetails>() {
				});
		return response.getBody();
	}
	
	public EducationDetails getEducationDetails(String uri) {
		ResponseEntity<EducationDetails> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<EducationDetails>() {
				});
		return response.getBody();
	}
	
	public WorkExperianceDetails getWorkExperianceDetails(String uri) {
		ResponseEntity<WorkExperianceDetails> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<WorkExperianceDetails>() {
				});
		return response.getBody();
	}


	public List<PostedJobsList> getListOfAllJobs(String uri) {
		ResponseEntity<List<PostedJobsList>> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<PostedJobsList>>() {
				});
		return response.getBody();
	}
	
	public List<PostedJobsList> getAppliedJobs(String uri) {
		ResponseEntity<List<PostedJobsList>> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<PostedJobsList>>() {
				});
		return response.getBody();

	}
	
	public HttpStatus updateWorkExperianceDetails(String uri, WorkExperianceDetails workExperianceDetails){
		ResponseEntity<WorkExperianceDetails> response = template.postForEntity(EndPointConstant.JOBSEEKER_URI+uri, workExperianceDetails, 
				WorkExperianceDetails.class );
		return response.getStatusCode();
	}
	
	public HttpStatus updatePersonalDetails(String uri, PersonalDetails personalDetails){
		ResponseEntity<PersonalDetails> response = template.postForEntity(EndPointConstant.JOBSEEKER_URI+uri, personalDetails, 
				PersonalDetails.class );
		return response.getStatusCode();
	}
	
	public HttpStatus updateEducationDetails(String uri, EducationDetails educationDetails){
		ResponseEntity<EducationDetails> response = template.postForEntity(EndPointConstant.JOBSEEKER_URI+uri, educationDetails, 
				EducationDetails.class );
		return response.getStatusCode();
	}

	public HttpStatus postFeedBack(String uri, FeedBack feedBack){
		ResponseEntity<FeedBack> response = template.postForEntity(EndPointConstant.JOBSEEKER_URI+uri, feedBack, 
				FeedBack.class );
		return response.getStatusCode();
	}

}
