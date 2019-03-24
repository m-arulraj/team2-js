
package com.virtusa.semicolon.jobseeker_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.PostedJobsList;
import com.virtusa.semicolon.jobseeker_service.repository.PostedJobsListRepository;

@Service
public class SearchingService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;

	public List<PostedJobsList> getSearchedJobs(String jobTitle) {
		return postedJobsListRepository.findByJobTitleContainingIgnoreCase(jobTitle);
	}

}
