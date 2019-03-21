package com.virtusa.semicolon.employer_service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.service.EmployerService;

@RestController
@RequestMapping("/api/semicolonemployer")
public class EmployerResource {

	String api="/api/semicolonemployer";
	
	@Autowired
	EmployerService employerService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> postingJob(@RequestBody PostedJobsList jobsList) throws URISyntaxException
	{
		return ResponseEntity.created(new URI(api+employerService.postingJob(jobsList).getJobTitle())).build();	
	}
	
/*	@RequestMapping(value="/{jobTitle}",method=RequestMethod.PUT)
	public PostedJobsList managingJob(@PathVariable("jobTitle")String jobTitle,@RequestBody PostedJobsList postedJobsList)
	{
		return employerService.managingJob(jobTitle, postedJobsList);
		
	}*/
}
