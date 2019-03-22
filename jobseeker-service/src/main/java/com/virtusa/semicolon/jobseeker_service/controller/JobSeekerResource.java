package com.virtusa.semicolon.jobseeker_service.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;
import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.repository.PersonalDetailsRepository;
import com.virtusa.semicolon.jobseeker_service.service.JobApplyingService;
import com.virtusa.semicolon.jobseeker_service.service.UpdationService;

@RestController
@RequestMapping("/api/jobseeker")
public class JobSeekerResource {

	@Autowired
	UpdationService updationService;

	@Autowired
	JobApplyingService jobApplyingService;

	@Autowired
	PersonalDetailsRepository personalDetailsRepository;

	@RequestMapping(value = "/personaldetails", method = RequestMethod.POST)
	private ResponseEntity<String> savePersonalDetails(@RequestBody PersonalDetails personalDetails)
			throws URISyntaxException {
		PersonalDetails person= personalDetailsRepository.findByUserName(personalDetails.getUserName());
		if (person != null) {
			
			
			personalDetails.setId(person.getId());
			
			System.out.println(personalDetails.getUserName());
			updationService.save(personalDetails);
			return (ResponseEntity<String>) ResponseEntity.ok();
		} else {
			return ResponseEntity
					.created(new URI("/api/jobseeker" + updationService.savePersonalDetails(personalDetails).getId()))
					.build();
		}

	}
	/*
	 * @RequestMapping(value = "/educationdetails", method = RequestMethod.POST)
	 * private ResponseEntity<String> saveEducationDetails(@RequestBody
	 * EducationDetails educationDetails) throws URISyntaxException {
	 * PersonalDetails personalDetails; return ResponseEntity. created(new
	 * URI("/api/jobseeker" +
	 * updationService.savePersonalDetails(personalDetails).getId())) .build();
	 * }
	 */

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public PersonalDetails getPersonalDetails(@RequestParam("id") Long id) {
		return updationService.get(id);
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public ResponseEntity<String> applyForJob(@RequestBody AppliedJobs appliedJobs) throws URISyntaxException {
		return ResponseEntity.created(new URI("/api/jobseeker" + jobApplyingService.applyForJobs(appliedJobs).getId()))
				.build();
	}

}
