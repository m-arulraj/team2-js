
package com.virtusa.semicolon.employer_service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;
import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.service.CompanyDetailsService;
import com.virtusa.semicolon.employer_service.service.EmployerService;

@RestController
@RequestMapping("/api/employer")
public class EmployerResource {

	String api = "/api/employer";

	@Autowired
	CompanyDetailsService companyDetailsService;

	@Autowired
	EmployerService employerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> postingJob(@RequestBody PostedJobsList jobsList) throws URISyntaxException {
		return ResponseEntity.created(new URI(api + employerService.postingJob(jobsList).getJobTitle())).build();
	}

	@PutMapping("/managingJobs/{jobId}")
	public PostedJobsList managingJobsList(@PathVariable("jobId") String jobId, @RequestBody PostedJobsList jobsList) {
		return employerService.managingJobsList(jobId, jobsList);

	}
	@PutMapping("/companyDetails/{userName}")
	public int updateEmployerDetails(@PathVariable("userName") String userName,@RequestBody CompanyDetails companyDetails)
	{
		return companyDetailsService.updateEmployerDetails(userName, companyDetails);
		
	}
}
