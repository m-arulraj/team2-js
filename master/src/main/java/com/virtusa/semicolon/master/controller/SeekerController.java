package com.virtusa.semicolon.master.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.EducationDetails;
import com.virtusa.semicolon.master.domain.FeedBack;
import com.virtusa.semicolon.master.domain.PersonalDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.domain.WorkExperianceDetails;
import com.virtusa.semicolon.master.service.JobSeekerService;

@Controller
@RequestMapping("/seeker")
public class SeekerController {

	@Autowired
	JobSeekerService jobSeekerService;

	// seeker homepage
	@GetMapping("")
	public ModelAndView getDetails(HttpSession session, Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-home");
		String uri = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri);
		String uri2 = "/alljobs";
		List<PostedJobsList> requestList = jobSeekerService.getListOfAllJobs(uri2);
		model.addObject("personalDetails", personalDetails);
		model.addObject("postedJobsList", requestList);
		return model;
	}

	// seeker profile
	@GetMapping("/profile")
	public ModelAndView updateProfile(HttpSession session, Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-profile");
		String uri = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri);
		String uri3 = "/educationdetails?userName=" + userName;
		EducationDetails educationDetails = jobSeekerService.getEducationDetails(uri3);
		String uri4 = "/workexperiancedetails?userName=" + userName;
		WorkExperianceDetails workExperianceDetails = jobSeekerService.getWorkExperianceDetails(uri4);
		model.addObject("personalDetails", personalDetails==null?new PersonalDetails():personalDetails);
		model.addObject("educationDetails", educationDetails==null?new EducationDetails():educationDetails);
		model.addObject("workExperianceDetails", workExperianceDetails==null?new WorkExperianceDetails():workExperianceDetails);
		return model;
	}

	// seeker applied jobs
	@GetMapping("/searchedjobs")
	public ModelAndView searchedJobs(@RequestParam("jobTitle") String jobTitle, HttpSession session,
			Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		System.out.println(jobTitle);
		ModelAndView model = new ModelAndView("seeker-home");
		String uri = "/searchedjobs?jobTitle=" + jobTitle;
		List<PostedJobsList> requestList = jobSeekerService.getListOfJobs(uri);
		String uri2 = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri2);
		System.out.println(personalDetails);
		model.addObject("personalDetails", personalDetails);
		model.addObject("postedJobsList", requestList);
		return model;
	}

	// seeker report
	@GetMapping("/report")
	public ModelAndView getreport(HttpSession session, Principal principal,@RequestParam("jobId") String jobId) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-report-something");
		String uri = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri);
		model.addObject("personalDetails", personalDetails);
		model.addObject("jobId", jobId);
		return model;
	}
	
	@PostMapping("/feedback")
	public ModelAndView postreport(@ModelAttribute("feedBack") FeedBack feedBack,HttpSession session, Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-home");
		String uri = "/feedback?userName=" + session.getAttribute("userName");
		jobSeekerService.postFeedBack(uri,feedBack);
		String uri2 = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri2);
		String uri3 = "/alljobs";
		List<PostedJobsList> requestList = jobSeekerService.getListOfAllJobs(uri3);
		model.addObject("postedJobsList", requestList);
		model.addObject("personalDetails", personalDetails);
		return model;
	}

	@GetMapping("/jobs")
	public ModelAndView appliedJobs(HttpSession session, Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-applied-jobs");
		String uri = "/personaldetails?userName=" + userName;
		PersonalDetails personalDetails = jobSeekerService.getPersonalDetails(uri);
		String uri2 = "/appliedjobs?userName=" + userName;
		List<PostedJobsList> requestList = jobSeekerService.getAppliedJobs(uri2);
		model.addObject("personalDetails", personalDetails);
		model.addObject("postedJobsList", requestList);
		return model;
	}

	@PostMapping("/workexperiancedetails")
	public ModelAndView updateWorkExperianceDetails(
			@ModelAttribute("workExperianceDetails") WorkExperianceDetails workExperianceDetails, HttpSession session) {
		String uri = "/workexperiancedetails?userName=" + session.getAttribute("userName");
		jobSeekerService.updateWorkExperianceDetails(uri,workExperianceDetails);
		ModelAndView model = new ModelAndView("seeker-profile");
		String uri2 = "/workexperiancedetails?userName=" + session.getAttribute("userName");
		WorkExperianceDetails workExperianceDetails2 = jobSeekerService.getWorkExperianceDetails(uri2);
		String uri3 = "/personaldetails?userName=" + session.getAttribute("userName");
		PersonalDetails personalDetails2 = jobSeekerService.getPersonalDetails(uri3);
		String uri4 = "/educationdetails?userName=" + session.getAttribute("userName");
		EducationDetails educationDetails2 = jobSeekerService.getEducationDetails(uri4);
		model.addObject("educationDetails", educationDetails2==null?new EducationDetails():educationDetails2);
		model.addObject("personalDetails", personalDetails2==null?new PersonalDetails():personalDetails2);
		model.addObject("workExperianceDetails", workExperianceDetails2==null?new WorkExperianceDetails():workExperianceDetails2);
		return model;

	}
	
	@PostMapping("/personaldetails")
	public ModelAndView updatePersonalDetails(
			@ModelAttribute("personalDetails") PersonalDetails personalDetails, HttpSession session) {
		String uri = "/personaldetails?userName=" + session.getAttribute("userName");
		jobSeekerService.updatePersonalDetails(uri,personalDetails);
		ModelAndView model = new ModelAndView("seeker-profile");
		String uri2 = "/personaldetails?userName=" + session.getAttribute("userName");
		PersonalDetails personalDetails2 = jobSeekerService.getPersonalDetails(uri2);
		String uri3 = "/workexperiancedetails?userName=" + session.getAttribute("userName");
		WorkExperianceDetails workExperianceDetails2 = jobSeekerService.getWorkExperianceDetails(uri3);
		String uri4 = "/educationdetails?userName=" + session.getAttribute("userName");
		EducationDetails educationDetails2 = jobSeekerService.getEducationDetails(uri4);
		model.addObject("educationDetails", educationDetails2==null?new EducationDetails():educationDetails2);
		model.addObject("personalDetails", personalDetails2==null?new PersonalDetails():personalDetails2);
		model.addObject("workExperianceDetails", workExperianceDetails2==null?new WorkExperianceDetails():workExperianceDetails2);
		return model;

	}
	
	@PostMapping("/educationdetails")
	public ModelAndView updateEducationDetails(
			@ModelAttribute("educationDetails") EducationDetails educationDetails, HttpSession session) {
		String uri = "/educationdetails?userName=" + session.getAttribute("userName");
		jobSeekerService.updateEducationDetails(uri,educationDetails);
		ModelAndView model = new ModelAndView("seeker-profile");
		String uri2 = "/educationdetails?userName=" + session.getAttribute("userName");
		EducationDetails educationDetails2 = jobSeekerService.getEducationDetails(uri2);
		String uri3 = "/workexperiancedetails?userName=" + session.getAttribute("userName");
		WorkExperianceDetails workExperianceDetails2 = jobSeekerService.getWorkExperianceDetails(uri3);
		String uri4 = "/personaldetails?userName=" + session.getAttribute("userName");
		PersonalDetails personalDetails2 = jobSeekerService.getPersonalDetails(uri4);
		model.addObject("educationDetails", educationDetails2==null?new EducationDetails():educationDetails2);
		model.addObject("personalDetails", personalDetails2==null?new PersonalDetails():personalDetails2);
		model.addObject("workExperianceDetails", workExperianceDetails2==null?new WorkExperianceDetails():workExperianceDetails2);
		return model;

	}
}
