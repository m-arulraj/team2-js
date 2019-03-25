package com.virtusa.semicolon.jobseeker_service.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;
import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.FeedBack;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PostedJobsList;
import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;
import com.virtusa.semicolon.jobseeker_service.service.FeedBackService;
import com.virtusa.semicolon.jobseeker_service.service.JobApplyingService;
import com.virtusa.semicolon.jobseeker_service.service.ProfileViewService;
import com.virtusa.semicolon.jobseeker_service.service.SearchingService;
import com.virtusa.semicolon.jobseeker_service.service.UpdationService;

@RestController
@RequestMapping("/api/jobseeker/")
public class JobSeekerResource {

	@Autowired
	UpdationService updationService;

	@Autowired
	JobApplyingService jobApplyingService;

	@Autowired
	FeedBackService feedBackService;
	
	@Autowired
	ProfileViewService profileViewService;
	
	@Autowired
	SearchingService searchingService;

	@RequestMapping(value = "/updatepersonaldetails", method = RequestMethod.PUT)
	public PersonalDetails updatePersonalDetails(@RequestParam("userName") String userName,
			@RequestBody PersonalDetails personalDetails) throws ParseException {

		return updationService.updatePersonalDetails(userName, personalDetails);
	}

	@RequestMapping(value = "/updateeducationdetails", method = RequestMethod.PUT)
	public EducationDetails updateEducationDetails(@SessionAttribute("userName") String userName,
			@RequestBody EducationDetails educationDetails) {
		return updationService.updateEducationDetails(userName, educationDetails);
	}

	@RequestMapping(value = "/updateworkexperiancedetails", method = RequestMethod.PUT)
	public WorkExperianceDetails updateWorkExperianceDetails(@SessionAttribute("userName") String userName,
			@RequestBody WorkExperianceDetails workExperianceDetails) {
		return updationService.updateWorkExperianceDetails(userName, workExperianceDetails);

	}

	@RequestMapping(value = "/applyforjob", method = RequestMethod.POST)
	public ResponseEntity<String> applyForJob(/*@SessionAttribute("userName") String userName,@RequestParam("jobId") Long jobId*/@RequestBody AppliedJobs appliedJobs) throws URISyntaxException {
		return ResponseEntity.created(new URI("/api/jobseeker" + jobApplyingService.applyForJob(appliedJobs.getUserName(),appliedJobs.getJobId()).getId()))
				.build();
	}
	
	@RequestMapping(value = "/givefeedback", method = RequestMethod.POST)
	public ResponseEntity<String> giveFeedBack(@SessionAttribute("userNAme") String userName,
			@RequestParam("jobId") Long jobId, @RequestBody FeedBack feedBack) throws URISyntaxException{
		return ResponseEntity.created(new URI("/api/jobseeker" + feedBackService.giveFeedBack(userName,jobId,feedBack).getId()))
				.build();
	}
	
	@RequestMapping(value = "/getprofiledetails", method = RequestMethod.GET)
	public String getProfileDetails(@SessionAttribute("userName") String userName,Model model) {
		PersonalDetails personalDetails = profileViewService.getPersonalDetails(userName);
		EducationDetails educationDetails = profileViewService.getEducationDetails(userName);
		Optional<WorkExperianceDetails> workExperianceDetails = profileViewService.getWorkExperianceDetails(userName);
		model.addAttribute("personalDetails", personalDetails);
		model.addAttribute("educationDetails", educationDetails);
		model.addAttribute("workExperianceDetails", workExperianceDetails);
		return null;
	}
	
	@RequestMapping(value = "/getsearchedjobs", method = RequestMethod.GET)
	public List<PostedJobsList> getSearchedJobs(@RequestParam("jobTitle") String jobTitle) {
		return searchingService.getSearchedJobs(jobTitle);
	}

}
