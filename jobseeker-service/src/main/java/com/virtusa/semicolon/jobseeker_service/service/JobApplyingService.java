
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;
import com.virtusa.semicolon.jobseeker_service.repository.AppliedJobsRepository;

@Service
public class JobApplyingService {

	@Autowired
	AppliedJobsRepository appliedJobsRepository;

	public AppliedJobs applyForJob(String userName, Long jobId) {
		AppliedJobs appliedJobs = appliedJobsRepository.findByUserNameAndJobId(userName, jobId);
		if (appliedJobs != null) {
			return appliedJobsRepository.save(appliedJobs);
		} else {
			appliedJobs = new AppliedJobs();
			appliedJobs.setUserName(userName);
			appliedJobs.setJobId(jobId);
			return appliedJobsRepository.save(appliedJobs);
		}
	}

}
