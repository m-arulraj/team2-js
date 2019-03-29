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
import com.virtusa.semicolon.jobseeker_service.domain.FeedBack;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedBackTest {

	@Autowired
	WebApplicationContext wac;

	private MockMvc mock;

	@Before
	public void setup() {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void feedBackTest() throws Exception {
		FeedBack feedBack = new FeedBack();
		feedBack.setUserName("srini@gmail.com");
		feedBack.setJobId("2L");
		feedBack.setMessage("FakeJob");
		mock.perform(MockMvcRequestBuilders.post("/api/jobseeker/givefeedback").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(feedBack))).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
