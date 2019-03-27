
package com.virtusa.semicolon.jobseeker_service.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;
import com.virtusa.semicolon.jobseeker_service.domain.PostedJobsList;
import com.virtusa.semicolon.jobseeker_service.repository.AppliedJobsRepository;
import com.virtusa.semicolon.jobseeker_service.repository.PostedJobsListRepository;

@Service
public class PostedJobsService {
	
	@Autowired
	PostedJobsListRepository postedJobsListRepository;
	
	@Autowired
	AppliedJobsRepository appliedJobsRepository;

	public List<PostedJobsList> getSearchedJobs(String jobTitle) {
		return postedJobsListRepository.findByJobTitleContainingIgnoreCase(jobTitle);
	}

	public List<PostedJobsList> getAllJobs() {
		return postedJobsListRepository.findAll();
	}

	public List<PostedJobsList> getAppliedJobs(String userName) {
		AppliedJobs appliedJobs2 = new AppliedJobs();
		List<PostedJobsList> jobList = new ArrayList<>();
		List<AppliedJobs> appliedJobs = appliedJobsRepository.findByUserName(userName);
		Iterator<AppliedJobs> itr = appliedJobs.iterator();
		while(itr.hasNext()){
			appliedJobs2 = itr.next();
			Long jobId = appliedJobs2.getJobId();
			System.out.println(jobId);
			PostedJobsList postedJobsList = postedJobsListRepository.findByJobId(jobId);
			jobList.add(postedJobsList);
		}
		return jobList;
	}

}
