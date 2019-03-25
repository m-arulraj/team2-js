package com.virtusa.semicolon.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.semicolon.master.domain.PostedJobsList;

@Controller
@RequestMapping("/employer")
public class EmployerController {

	//employer homepage
	@GetMapping("")
	public String seekerHomePage() {
		return "employer-home";
	}
	
	//seeker profile
		@GetMapping("/profile")
		public String updateProfile() {
			return "employer-profile";
		}

		//seeker applied jobs
		@GetMapping("/jobs")
		public ModelAndView appliedJobs() {
			List<String> postedjobList = new ArrayList<>();
			postedjobList.add("javaDeveloper");
			postedjobList.add("dot net developer");
			postedjobList.add("UI developer");
			ModelAndView model = new ModelAndView("employer-posted-jobs");
			model.addObject("postedjobList", postedjobList);
			return model;
		}
		@ModelAttribute("postedjobs")
		public PostedJobsList postjob(){
			return  new PostedJobsList();
		}
	
		//seeker report
		@GetMapping("/postjob")
		public String report() {
			return "employer-home";
		}
}
