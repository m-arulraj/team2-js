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

	public List<String> managingJobList(String id) {
		System.out.println(id);
		return postedJobsListRepository.managingJobList(id);
	}
	

	
}
