package com.virtusa.semicolon.master.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.CompanyDetails;
import com.virtusa.semicolon.master.domain.PostedJobsList;
import com.virtusa.semicolon.master.service.EmployerService;

@Controller
@RequestMapping("/employer")
public class EmployerController {
@Autowired
EmployerService employerService;
	//employer homepage
	@GetMapping("")
	public ModelAndView seekerHomePage(HttpSession session, Principal principal) {
		
		    String uname= principal.getName();
		    session.setAttribute("username", uname);
		    String uri = "/getcompanydetails?userName="+session.getAttribute("username");
		    CompanyDetails companyDetails =employerService.getCompanyDetails(uri);
		    System.out.println(companyDetails);
		    String uri1="/getpostedjobs?userName="+session.getAttribute("username");
		    List<PostedJobsList> postedjobList = employerService.getListOfjobs(uri1);
			ModelAndView model = new ModelAndView("employer-home");
		model.addObject("postedjobList", postedjobList);
		model.addObject("companyDetails",companyDetails);
		//model.addObject("uname",uname);
		return model;
	
	}
	
	//seeker profile
		@GetMapping("/profile")
		public String updateProfile(HttpSession session, Model model) {
			 String uri = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri);
			    model.addAttribute(companyDetails);
			return "employer-profile";
		}
		
		@ModelAttribute("companydetails")
		public CompanyDetails updatecompanyDetails(){
			return  new CompanyDetails();
		}
		@PostMapping("/updateprofile")
		public ModelAndView updateProfile(@ModelAttribute("companydetails") CompanyDetails companyDetails1, HttpSession session) {
			
				String uri="/updatecompanydetails?userName="+session.getAttribute("username");
				System.out.println("com" +uri);
				 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
				    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
				ModelAndView model = new ModelAndView("employer-home");
				employerService.updateCompanyDetails(uri, companyDetails1);
				model.addObject("companyDetails", companyDetails);
				return model;
			
		}
		//seeker applied jobs
		@GetMapping("/jobs")
		public ModelAndView postedJobs(HttpSession session) {
			String uri="/getpostedjobs?userName="+session.getAttribute("username");
			 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
			ModelAndView model = new ModelAndView("employer-posted-jobs");
			List<PostedJobsList> postedjobList = employerService.getListOfjobs(uri);
			model.addObject("postedjobList", postedjobList);
			model.addObject("companyDetails",companyDetails);

			return model;
			
			/*List<String> postedjobList = new ArrayList<>();
			postedjobList.add("javaDeveloper");
			postedjobList.add("dot net developer");
			postedjobList.add("UI developer");
			ModelAndView model = new ModelAndView("employer-posted-jobs");
			model.addObject("postedjobList", postedjobList);
			return model;*/
		}
		@ModelAttribute("postedjobs")
		public PostedJobsList postjob(){
			return  new PostedJobsList();
		}
		
	
		//seeker report
		@PostMapping("/postjob")
		public ModelAndView postJobs(@ModelAttribute("postedjobs") PostedJobsList postedjoblist,HttpSession session) {
			String uri="/postjobs?userName="+session.getAttribute("username");
			System.out.println("uri" +uri);
			ModelAndView model = new ModelAndView("employer-posted-jobs");
			HttpStatus http = employerService.postJobs(uri, postedjoblist);
			if(http.equals(http.CREATED)){
				model=postedJobs(session);
			
			}
			return model;
		}
		@RequestMapping("/deletejob")
		public ModelAndView deleteJobs(@RequestParam("id") Long id,HttpSession session) {
			String uri="/removejob?id="+id;
				employerService.deleteJob(uri);
				ModelAndView model = new ModelAndView("employer-posted-jobs");
				
				model=postedJobs(session);
				return model;
}
}
