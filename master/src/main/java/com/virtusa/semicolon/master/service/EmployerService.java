package com.virtusa.semicolon.master.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.virtusa.semicolon.master.domain.CompanyDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.util.EndPointConstant;
@Repository
public class EmployerService {
RestTemplate template = new RestTemplate();

	

	public List<PostedJobsList> getListOfjobs(String uri) {
		ResponseEntity<List<PostedJobsList>> response = template.exchange(EndPointConstant.EMPLOYER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<PostedJobsList>>() {
				});
		return response.getBody();

	}
	
	public HttpStatus postJobs(String uri,PostedJobsList postedJobList){	
		ResponseEntity<PostedJobsList> response = template.postForEntity(EndPointConstant.EMPLOYER_URI+uri, postedJobList, 
				PostedJobsList.class );
		return response.getStatusCode();
	}
	
	public HttpStatus updateCompanyDetails(String uri, CompanyDetails companyDetails){
		ResponseEntity<CompanyDetails> response = template.postForEntity(EndPointConstant.EMPLOYER_URI+uri, companyDetails, 
				CompanyDetails.class );
		return response.getStatusCode();
	}
	
	public void deleteJob(String uri){
		template.delete(EndPointConstant.EMPLOYER_URI+uri);
	}
	
	public CompanyDetails getCompanyDetails(String uri) {
		ResponseEntity<CompanyDetails> response = template.exchange(EndPointConstant.EMPLOYER_URI+uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<CompanyDetails>() {
				});
		return response.getBody();

	}
}
