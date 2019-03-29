
package com.virtusa.semicolon.jobseeker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.semicolon.jobseeker_service.domain.FeedBack;
import com.virtusa.semicolon.jobseeker_service.repository.FeedBackRepository;

@Service
public class FeedBackService {

	@Autowired
	FeedBackRepository feedBackRepository;

	public FeedBack giveFeedBack(String userName, String jobId, FeedBack feedBack) {
		FeedBack feedBack2 = feedBackRepository.findByUserNameAndJobId(userName,jobId);
		if (feedBack2 != null) {
			return feedBackRepository.save(feedBack2);
		} else {
			feedBack2 = new FeedBack();
			feedBack2.setUserName(userName);
			feedBack2.setJobId(jobId);
			feedBack2.setMessage(feedBack.getMessage());
			return feedBackRepository.save(feedBack2);
		}

	}

	public FeedBack getFeedBack(String jobId) {
		return feedBackRepository.findByJobId(jobId);
	}

}
