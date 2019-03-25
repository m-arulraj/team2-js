package com.virtusa.semicolon.employer_service.test;

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
import com.virtusa.semicolon.employer_service.domain.PostedJobsList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostingJobTest {
	
	@Autowired
	WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void jobPostingTest() throws Exception{
		PostedJobsList postedJobsList = new PostedJobsList();
		postedJobsList.setJobDescription("A Job for Everyone");
		postedJobsList.setJobId("239igd");
		postedJobsList.setJobTitle("Java Developer");
		postedJobsList.setJobType("IT");
		postedJobsList.setRequiredSkills("Java,Spring");
		postedJobsList.setSalary(25000D);
		postedJobsList.setNumberOfVacancies(10L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/employer/postjobs?userName=shubam@outlook.com")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(postedJobsList)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
