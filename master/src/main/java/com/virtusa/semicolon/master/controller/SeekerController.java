package com.virtusa.semicolon.master.controller;

import java.security.Principal;
<<<<<<< HEAD
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
=======

>>>>>>> c54d03ed89f23cdf1b280a7a0032870a1c7d6f81
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.PersonalDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.service.JobSeekerService;

@Controller
@RequestMapping("/seeker")
public class SeekerController {
	
	@Autowired
	JobSeekerService jobSeekerService;

	//seeker homepage
	@GetMapping("")
<<<<<<< HEAD
	public ModelAndView getDetails(HttpSession session,Principal principal) {
		String userName = principal.getName();
		session.setAttribute("userName", userName);
		System.out.println(userName);
		ModelAndView model = new ModelAndView("seeker-home");
		String uri="/personaldetails?userName="+userName;
		PersonalDetails personalDetails =jobSeekerService.getDetails(uri);
		System.out.println(personalDetails);
		model.addObject("personalDetails",personalDetails);
		return model;
=======
	public String seekerHomePage(Principal principal, Model model) {
		String uName= principal.getName();
		model.addAttribute(uName);
		return "seeker-home";
>>>>>>> c54d03ed89f23cdf1b280a7a0032870a1c7d6f81
	}
	
	//seeker profile
		@GetMapping("/profile")
		public String updateProfile() {
			return "seeker-profile";
		}

		//seeker applied jobs
		@GetMapping("/searchedjobs")
		public ModelAndView appliedJobs(@RequestParam("jobTitle") String jobTitle,HttpSession session,Principal principal) {
			String userName = principal.getName();
			session.setAttribute("userName", userName);
			System.out.println(jobTitle);
			ModelAndView model = new ModelAndView("seeker-home");
			String uri="/searchedjobs?jobTitle="+jobTitle;
			List<PostedJobsList> requestList =jobSeekerService.getListOfJobs(uri);
			String uri2="/personaldetails?userName="+userName;
			PersonalDetails personalDetails =jobSeekerService.getDetails(uri2);
			System.out.println(personalDetails);
			model.addObject("personalDetails",personalDetails);
			model.addObject("postedJobsList",requestList);
			return model;
		}
	
		//seeker report
		@GetMapping("/report")
		public String report() {
			return "seeker-report-something";
		}
}
