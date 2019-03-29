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
			 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
			ModelAndView model = new ModelAndView("employer-posted-jobs");
			model.addObject("companyDetails",companyDetails);
			//model.addObject("postedjobs", new PostedJobsList());

			return model;
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
			HttpStatus http = employerService.postJobs(uri, postedjoblist);
			ModelAndView model = new ModelAndView("employer-home");

			if(http.equals(http.CREATED)){
			 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
			 String uri2="/getpostedjobs?userName="+session.getAttribute("username");
			    List<PostedJobsList> postedjobList = employerService.getListOfjobs(uri2);
			model.addObject("postedjobList", postedjobList);
			model.addObject("companyDetails",companyDetails);			
			}
			return model;
		}
		@RequestMapping("/deletejob")
		public ModelAndView deleteJobs(@RequestParam("id") Long id,HttpSession session) {
			String uri="/removejob?id="+id;
				employerService.deleteJob(uri);
				ModelAndView model = new ModelAndView("employer-home");
				 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
				    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
				 String uri2="/getpostedjobs?userName="+session.getAttribute("username");
				    List<PostedJobsList> postedjobList = employerService.getListOfjobs(uri2);
				model.addObject("postedjobList", postedjobList);
				model.addObject("companyDetails",companyDetails);	
				
				return model;
}
		@GetMapping("/editjob")
		public ModelAndView updatejob(@RequestParam("id") Long id,HttpSession session) {
			 String uri = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri);
			    String uri1= "/getjob?id="+id;
			    PostedJobsList postedJobList = employerService.getpostedjob(uri1);
			    ModelAndView model = new ModelAndView("job-edit");
			    model.addObject("companyDetails", companyDetails);
			    model.addObject("postedJobList", postedJobList);			    
			return model;
		}
		@PostMapping("/updatedjobs")
		public ModelAndView updatedjobs(@ModelAttribute("postedjobs") PostedJobsList postedjoblist,HttpSession session) {
			String uri="/updatejob?id="+postedjoblist.getId();
			System.out.println("uri" +uri);
			ModelAndView model = new ModelAndView("employer-home");
			 String uri1 = "/getcompanydetails?userName="+session.getAttribute("username");
			    CompanyDetails companyDetails =employerService.getCompanyDetails(uri1);
			 String uri2="/getpostedjobs?userName="+session.getAttribute("username");
			    List<PostedJobsList> postedjobList = employerService.getListOfjobs(uri2);
			model.addObject("postedjobList", postedjobList);
			model.addObject("companyDetails",companyDetails);	
			 employerService.updateJobs(uri, postedjoblist);
			
			return model;
}
}
