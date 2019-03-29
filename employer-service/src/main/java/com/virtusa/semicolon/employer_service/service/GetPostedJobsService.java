package com.virtusa.semicolon.employer_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.repository.PostedJobsListRepository;

@Service
public class GetPostedJobsService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;

	public List<PostedJobsList> getPostedJobs(String userName) {
		return postedJobsListRepository.findByUserName(userName);
	}
	public PostedJobsList getJob(Long id) {
		return postedJobsListRepository.findjobsById(id);
	}
	
	public PostedJobsList updatePostedJobs(Long id,PostedJobsList jobsList){
		PostedJobsList postedJobsList = postedJobsListRepository.findjobsById(id);
		if(postedJobsList!=null){
			if(jobsList.getJobTitle()!=null){
				postedJobsList.setJobTitle(jobsList.getJobTitle());
			}
			if(jobsList.getJobDescription()!=null){
				postedJobsList.setJobDescription(jobsList.getJobDescription());
			}
			if(jobsList.getJobId()!=null){
				postedJobsList.setJobId(jobsList.getJobId());
			}
			if(jobsList.getJobType()!=null){
				postedJobsList.setJobType(jobsList.getJobType());
			}
			if(jobsList.getNumberOfVacancies()!=null){
				postedJobsList.setNumberOfVacancies(jobsList.getNumberOfVacancies());
			}
			if(jobsList.getRequiredSkills()!=null){
				postedJobsList.setRequiredSkills(jobsList.getRequiredSkills());
			}
			if(jobsList.getSalary()!=null){
				postedJobsList.setSalary(jobsList.getSalary());
			
			}
			if(jobsList.getPostedBy()!=null){
				postedJobsList.setPostedBy(jobsList.getPostedBy());;
			
			}
			return postedJobsListRepository.save(postedJobsList);
		}else{
			
			return postedJobsListRepository.save(jobsList);

		}
	}

}
