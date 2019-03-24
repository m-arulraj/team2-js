package com.virtusa.semicolon.jobseeker_service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchingTest {

	@Autowired
	WebApplicationContext wac;

	private MockMvc mock;

	@Before
	public void setup() {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void searchingTest() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/api/jobseeker/getsearchedjobs?jobTitle=se"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
