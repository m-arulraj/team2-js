package com.virtusa.semicolon.registration.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.semicolon.registration.domain.PersonalDetails;



@FeignClient(name="jobseeker-service")
public interface jobseekerServiceProxy {
	@RequestMapping(value = "/api/jobseeker/updatepersonaldetails", method = RequestMethod.PUT)
	public PersonalDetails updatePersonalDetails(@RequestParam("userName") String userName,
			@RequestBody PersonalDetails personalDetails);
}
