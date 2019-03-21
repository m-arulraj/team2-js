package com.virtusa.semicolon.employer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.repository.PostedJobsListRepository;

@Service
public class EmployerService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;
	
	@Transactional
	public PostedJobsList postingJob(PostedJobsList postedJobsList){
		return postedJobsListRepository.save(postedJobsList);
	}
	
	@Transactional
	public PostedJobsList managingJob(String name,PostedJobsList postedJobsList)
	{

		PostedJobsList pjs=new PostedJobsList();
		List<PostedJobsList> jobsList=postedJobsListRepository.findByJobname(name);
		if(jobsList !=null)
		{
			pjs.setJobDescription(postedJobsList.getJobDescription());
			pjs.setJobTitle(postedJobsList.getJobTitle());
			pjs.setNumberOfVacancies(postedJobsList.getNumberOfVacancies());
			pjs.setPostedBy(postedJobsList.getPostedBy());
			pjs.setRequiredSkills(postedJobsList.getRequiredSkills());
			pjs.setSalary(postedJobsList.getSalary());
		}
		return postedJobsListRepository.save(pjs);
		
	}
	
}
