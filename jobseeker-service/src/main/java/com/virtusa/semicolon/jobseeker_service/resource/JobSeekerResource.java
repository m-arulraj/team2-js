package com.virtusa.semicolon.jobseeker_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.FeedBack;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PostedJobsList;
import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;
import com.virtusa.semicolon.jobseeker_service.service.EducationDetailsService;
import com.virtusa.semicolon.jobseeker_service.service.FeedBackService;
import com.virtusa.semicolon.jobseeker_service.service.JobApplyingService;
import com.virtusa.semicolon.jobseeker_service.service.PersonalDetailsService;
import com.virtusa.semicolon.jobseeker_service.service.ProfileViewService;
import com.virtusa.semicolon.jobseeker_service.service.SearchingService;
import com.virtusa.semicolon.jobseeker_service.service.WorkExperianceDetailsService;

@RestController
@RequestMapping("/api/jobseeker/")
public class JobSeekerResource {

	@Autowired
	PersonalDetailsService personalDetailsService;
	
	@Autowired
	EducationDetailsService educationDetailsService;
	
	@Autowired
	WorkExperianceDetailsService workExperianceDetailsService;

	@Autowired
	JobApplyingService jobApplyingService;

	@Autowired
	FeedBackService feedBackService;
	
	@Autowired
	ProfileViewService profileViewService;
	
	@Autowired
	SearchingService searchingService;

	@RequestMapping(value = "/personaldetails", method = RequestMethod.PUT)
	public PersonalDetails updatePersonalDetails(@RequestParam("userName") String userName,
			@RequestBody PersonalDetails personalDetails) throws ParseException {

		return personalDetailsService.updatePersonalDetails(userName, personalDetails);
	}

	@RequestMapping(value = "/educationdetails", method = RequestMethod.PUT)
	public EducationDetails updateEducationDetails(@RequestParam("userName") String userName,
			@RequestBody EducationDetails educationDetails) {
		return educationDetailsService.updateEducationDetails(userName, educationDetails);
	}

	@RequestMapping(value = "/workexperiancedetails", method = RequestMethod.PUT)
	public WorkExperianceDetails updateWorkExperianceDetails(@RequestParam("userName") String userName,
			@RequestBody WorkExperianceDetails workExperianceDetails) {
		return workExperianceDetailsService.updateWorkExperianceDetails(userName, workExperianceDetails);

	}

	@RequestMapping(value = "/job", method = RequestMethod.POST)
	public ResponseEntity<String> applyForJob(@RequestParam("userName") String userName,@RequestParam("jobId") Long jobId) throws URISyntaxException {
		return ResponseEntity.created(new URI("/api/jobseeker" + jobApplyingService.applyForJob(userName,jobId).getId()))
				.build();
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public ResponseEntity<String> giveFeedBack(@SessionAttribute("userNAme") String userName,
			@RequestParam("jobId") Long jobId, @RequestBody FeedBack feedBack) throws URISyntaxException{
		return ResponseEntity.created(new URI("/api/jobseeker" + feedBackService.giveFeedBack(userName,jobId,feedBack).getId()))
				.build();
	}
	
	@RequestMapping(value = "/personaldetails", method = RequestMethod.GET)
	public PersonalDetails getPersonalDetails(@RequestParam("userName") String userName){
		return profileViewService.getPersonalDetails(userName);
	}
	
	@RequestMapping(value = "/educationdetails", method = RequestMethod.GET)
	public EducationDetails getEducationDetails(@RequestParam("userName") String userName){
		return profileViewService.getEducationDetails(userName);
	}
	
	@RequestMapping(value = "/workexperiancedetails", method = RequestMethod.GET)
	public Optional<WorkExperianceDetails> getWorkExperianceDetails(@RequestParam("userName") String userName){
		return profileViewService.getWorkExperianceDetails(userName);
	}
	
	@RequestMapping(value = "/searchedjobs", method = RequestMethod.GET)
	public List<PostedJobsList> getSearchedJobs(@RequestParam("jobTitle") String jobTitle) {
		return searchingService.getSearchedJobs(jobTitle);
	}

}
