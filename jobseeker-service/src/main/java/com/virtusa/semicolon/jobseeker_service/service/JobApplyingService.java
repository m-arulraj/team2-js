package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;
import com.virtusa.semicolon.jobseeker_service.repository.AppliedJobsRepository;

@Service
public class JobApplyingService {
	
	@Autowired
	AppliedJobsRepository appliedJobsRepository;

	public AppliedJobs applyForJobs(AppliedJobs appliedJobs){
		return appliedJobsRepository.save(appliedJobs);
	}

}
