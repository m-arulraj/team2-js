
package com.virtusa.semicolon.employer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.repository.CompanyDetailsRepository;
import com.virtusa.semicolon.employer_service.repository.PostedJobsListRepository;

@Service
public class PostingJobService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	@Transactional
	public PostedJobsList postingJob(PostedJobsList postedJobsList){
		return postedJobsListRepository.save(postedJobsList);
	}
	
	public PostedJobsList postJobs(String userName,PostedJobsList jobsList) {
		String jobId = jobsList.getJobId();
		PostedJobsList postedJobsList = postedJobsListRepository.findByUserNameAndJobId(userName,jobId);
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
			return postedJobsListRepository.save(postedJobsList);
		}else{
			jobsList.setPostedBy(userName);
			return postedJobsListRepository.save(jobsList);

		}
	}
}

