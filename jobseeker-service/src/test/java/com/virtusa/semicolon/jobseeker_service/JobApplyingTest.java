package com.virtusa.semicolon.jobseeker_service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.semicolon.jobseeker_service.domain.AppliedJobs;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JobApplyingTest {

	@Autowired
	WebApplicationContext wac;
	
	private MockMvc mock;
	
	@Before
	public void setup(){
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testApplying() throws Exception{
		AppliedJobs appliedJobs = new AppliedJobs();
		appliedJobs.setJobId((long)0);
		appliedJobs.setUserName("srini@gmail.com");
		mock.perform(MockMvcRequestBuilders.post("/api/jobseeker/apply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(appliedJobs))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
