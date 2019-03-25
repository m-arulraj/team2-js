package com.virtusa.semicolon.employer_service.service;

import java.util.List;

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

}
