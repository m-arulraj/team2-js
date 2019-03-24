package com.virtusa.semicolon.jobseeker_service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.semicolon.jobseeker_service.domain.EducationDetails;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;
import com.virtusa.semicolon.jobseeker_service.domain.WorkExperianceDetails;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdationTest {

	@Autowired
	WebApplicationContext wac;

	private MockMvc mock;

	@Before
	public void setup() {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testPersonalDetailsUpdation() throws Exception {
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.setGender("M");
		mock.perform(MockMvcRequestBuilders.put("/api/jobseeker/updatepersonaldetails?userName=srini@gmail.com")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(personalDetails)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testEducationDetailsUpdation() throws Exception {
		EducationDetails educationDetails = new EducationDetails();
		educationDetails.setYearGap(3L);
		mock.perform(MockMvcRequestBuilders.put("/api/jobseeker/updateeducationdetails?userName=srini@gmail.com")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(educationDetails)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testWorkExperianceDetailsUpdation() throws Exception {
		WorkExperianceDetails workExperianceDetails = new WorkExperianceDetails();
		workExperianceDetails.setEndDate("2010-10-20");
		mock.perform(MockMvcRequestBuilders.put("/api/jobseeker/updateworkexperiancedetails?userName=srini@gmail.com")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(workExperianceDetails)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
