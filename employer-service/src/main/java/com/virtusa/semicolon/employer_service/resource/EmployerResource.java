<<<<<<< HEAD
package com.virtusa.semicolon.employer_service.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.service.EmployerService;

@RestController
@RequestMapping("/api/employer")
public class EmployerResource {

	String api = "/api/employer";

	@Autowired
	EmployerService employerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> postingJob(@RequestBody PostedJobsList jobsList) throws URISyntaxException {
		return ResponseEntity.created(new URI(api + employerService.postingJob(jobsList).getJobTitle())).build();
	}



}
=======
package com.virtusa.semicolon.employer_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.service.EmployerService;

@RestController
@RequestMapping("/api/employer")
public class EmployerResource {

	String api="/api/employer";
	
	@Autowired
	EmployerService employerService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> postingJob(@RequestBody PostedJobsList jobsList) throws URISyntaxException
	{
		return ResponseEntity.created(new URI(api+employerService.postingJob(jobsList).getJobTitle())).build();	
	}
	
	@GetMapping("/{id}")
	public List<String> getjobList(@PathVariable("id") String id)
	{
		return employerService.managingJobList(id);
	}
	

}
>>>>>>> 908a1bf75b7469635f0b7d499725f6ff684b05df
