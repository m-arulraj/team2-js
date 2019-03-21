<<<<<<< HEAD
package com.virtusa.semicolon.employer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.repository.CompanyDetailsRepository;
import com.virtusa.semicolon.employer_service.repository.PostedJobsListRepository;

@Service
public class EmployerService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	@Transactional
	public PostedJobsList postingJob(PostedJobsList postedJobsList){
		return postedJobsListRepository.save(postedJobsList);
	}
	
	public PostedJobsList managingJobsList(String jobTitle,PostedJobsList postedJobsList)
	{
		PostedJobsList jobsList=new PostedJobsList();
		List<String> list= postedJobsListRepository.getJobsIdList(jobTitle);
		if(list != null)
		{
			jobsList.setJobId(postedJobsList.getJobId());
			jobsList.setJobDescription(postedJobsList.getJobDescription());
			jobsList.setJobTitle(postedJobsList.getJobTitle());
			jobsList.setNumberOfVacancies(postedJobsList.getNumberOfVacancies());
			jobsList.setRequiredSkills(postedJobsList.getRequiredSkills());
			jobsList.setPostedBy(postedJobsList.getPostedBy());
			jobsList.setSalary(postedJobsList.getSalary());
		}else {
			System.out.println("Error");
		}		
		return postedJobsListRepository.save(jobsList);
	
	}
	
	public List<String> matchingJobsList(String jobTitle)
	{
		return postedJobsListRepository.getJobsTitleList(jobTitle);
	}
	
}
=======
package com.virtusa.semicolon.employer_service.service;

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
	


}
>>>>>>> eff3c661e9c768003e1ba6fd7a991ee82e990a76
