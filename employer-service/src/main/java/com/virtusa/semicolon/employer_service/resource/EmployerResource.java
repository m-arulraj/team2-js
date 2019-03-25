
package com.virtusa.semicolon.employer_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.semicolon.employer_service.domain.CompanyDetails;
import com.virtusa.semicolon.employer_service.domain.PostedJobsList;
import com.virtusa.semicolon.employer_service.service.CompanyDetailsService;
import com.virtusa.semicolon.employer_service.service.GetPostedJobsService;
import com.virtusa.semicolon.employer_service.service.PostingJobService;
import com.virtusa.semicolon.employer_service.service.RemovingJobService;

@RestController
@RequestMapping("/api/employer/")
public class EmployerResource {

	@Autowired
	CompanyDetailsService companyDetailsService;

	@Autowired
	PostingJobService postingJobService;

	@Autowired
	RemovingJobService removingJobService;
	
	@Autowired
	GetPostedJobsService getPostedJobsService;

	@RequestMapping(value = "/updatecompanydetails", method = RequestMethod.PUT)
	public CompanyDetails updateCompanyDetails(@RequestParam("userName") String userName,
			@RequestBody CompanyDetails companyDetails) {
		return companyDetailsService.updateCompanyDetails(userName, companyDetails);
	}

	@RequestMapping(value = "/postjobs", method = RequestMethod.POST)
	public ResponseEntity<String> postJobs(@RequestParam("userName") String userName,
			@RequestBody PostedJobsList jobsList) throws URISyntaxException {
		return ResponseEntity
				.created(new URI("/api/employer/" + postingJobService.postJobs(userName, jobsList).getId())).build();
	}

	@RequestMapping(value = "/removejob", method = RequestMethod.DELETE)
	public void removeJob(@RequestParam("id") Long id) {
		removingJobService.removeJob(id);
	}
	
	@RequestMapping(value = "/getpostedjobs", method = RequestMethod.GET)
	public List<PostedJobsList> getPostedJobs(@RequestParam("userName") String userName){
		return getPostedJobsService.getPostedJobs(userName);
	}

}
