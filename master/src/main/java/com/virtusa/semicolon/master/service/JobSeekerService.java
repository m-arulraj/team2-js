package com.virtusa.semicolon.master.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.semicolon.master.domain.PersonalDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
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



	public PersonalDetails getDetails(String uri) {
		ResponseEntity<PersonalDetails> response = template.exchange(EndPointConstant.JOBSEEKER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<PersonalDetails>() {
				});
		return response.getBody();
	}

}
