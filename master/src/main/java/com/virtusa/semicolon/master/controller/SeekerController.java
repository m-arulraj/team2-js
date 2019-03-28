package com.virtusa.semicolon.master.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.EducationDetails;
import com.virtusa.semicolon.master.domain.PersonalDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.domain.WorkExperianceDetails;
import com.virtusa.semicolon.master.service.JobSeekerService;

@Controller
@RequestMapping("/seeker")
public class SeekerController {
	
	@Autowired
	JobSeekerService jobSeekerService;

	//seeker homepage
	@GetMapping("")
	public ModelAndView getDetails(HttpSession session,Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		ModelAndView model = new ModelAndView("seeker-home");
		String uri="/personaldetails?userName="+userName;
		PersonalDetails personalDetails =jobSeekerService.getPersonalDetails(uri);
		String uri2="/alljobs";
		List<PostedJobsList> requestList =jobSeekerService.getListOfAllJobs(uri2);
		model.addObject("personalDetails",personalDetails);
		model.addObject("postedJobsList",requestList);
		return model;
	}
	
	//seeker profile
		@GetMapping("/profile")
		public ModelAndView updateProfile(HttpSession session,Principal principal) {
			String userName = principal.getName();
			session.setAttribute("userName", userName);
			ModelAndView model = new ModelAndView("seeker-profile");
			String uri="/personaldetails?userName="+userName;
			PersonalDetails personalDetails =jobSeekerService.getPersonalDetails(uri);
			String uri3="/educationdetails?userName="+userName;
			EducationDetails educationDetails =jobSeekerService.getEducationDetails(uri3);
			String uri4="/workexperiancedetails?userName="+userName;
			WorkExperianceDetails workExperianceDetails =jobSeekerService.getWorkExperianceDetails(uri4);
			model.addObject("personalDetails",personalDetails);
			model.addObject("educationDetails",educationDetails);
			model.addObject("workExperianceDetails",workExperianceDetails);
			return model;
		}

		//seeker applied jobs
		@GetMapping("/searchedjobs")
		public ModelAndView searchedJobs(@RequestParam("jobTitle") String jobTitle,HttpSession session,Principal principal) {
			String userName = principal.getName();
			session.setAttribute("userName", userName);
			System.out.println(jobTitle);
			ModelAndView model = new ModelAndView("seeker-home");
			String uri="/searchedjobs?jobTitle="+jobTitle;
			List<PostedJobsList> requestList =jobSeekerService.getListOfJobs(uri);
			String uri2="/personaldetails?userName="+userName;
			PersonalDetails personalDetails =jobSeekerService.getPersonalDetails(uri2);
			System.out.println(personalDetails);
			model.addObject("personalDetails",personalDetails);
			model.addObject("postedJobsList",requestList);
			return model;
		}
	
		//seeker report
		@GetMapping("/report")
		public ModelAndView report(HttpSession session,Principal principal) {
			String userName = principal.getName();
			session.setAttribute("userName", userName);
			ModelAndView model = new ModelAndView("seeker-report-something");
			String uri="/personaldetails?userName="+userName;
			PersonalDetails personalDetails =jobSeekerService.getPersonalDetails(uri);
			model.addObject("personalDetails",personalDetails);
			return model;
		}
		
		@GetMapping("/jobs")
		public ModelAndView appliedJobs(HttpSession session,Principal principal){
			String userName = principal.getName();
			session.setAttribute("userName", userName);
			ModelAndView model = new ModelAndView("seeker-applied-jobs");
			String uri="/personaldetails?userName="+userName;
			PersonalDetails personalDetails =jobSeekerService.getPersonalDetails(uri);
			String uri2="/appliedjobs?userName="+userName;
			List<PostedJobsList> requestList =jobSeekerService.getAppliedJobs(uri2);
			model.addObject("personalDetails",personalDetails);
			model.addObject("postedJobsList",requestList);
			return model;
		}
		
}
