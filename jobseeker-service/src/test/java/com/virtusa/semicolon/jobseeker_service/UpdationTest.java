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
import com.virtusa.semicolon.jobseeker_service.controller.JobSeekerResource;
import com.virtusa.semicolon.jobseeker_service.domain.PersonalDetails;

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
	public void testUpdation() throws Exception {
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.setId(70L);
		personalDetails.setUserName("srini@gmail.com");
		personalDetails.setAddress("DSDF");
		personalDetails.setContactNumber((long) 834574075);
		personalDetails.setCountry("some");
		personalDetails.setDateOfBirth("2013-12-11");
		personalDetails.setFatherName("sdfsd");
		personalDetails.setFirstName("a");
		personalDetails.setGender("Male");
		personalDetails.setState("dsf");
		personalDetails.setLastName("fg");
		personalDetails.setPincode((long) 34543);
		mock.perform(
				MockMvcRequestBuilders.post("/api/jobseeker/personaldetails").contentType(MediaType.APPLICATION_JSON)

						.content(new Gson().toJson(personalDetails)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		System.out.println("test");
	}

	@Test
	public void getPersonalDetails() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/api/jobseeker/get?id=1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
