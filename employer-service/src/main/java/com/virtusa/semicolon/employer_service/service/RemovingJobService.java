package com.virtusa.semicolon.employer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.employer_service.repository.PostedJobsListRepository;

@Service
public class RemovingJobService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;

	public void removeJob(Long id) {
		postedJobsListRepository.deleteById(id);
	}

}
