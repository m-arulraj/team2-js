<<<<<<< HEAD
package com.virtusa.semicolon.employer_service.test;

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
public class EmployerServiceTest {

	MockMvc mockmvc;

	@Autowired
	private WebApplicationContext ac;

	@org.junit.Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(ac).build();
	}
/*
	@Test
	public void employerServiceTest() throws Exception {
		PostedJobsList ps = new PostedJobsList("vamsi@gmail.com", "jobTitle", 20L, 5000D, "jobId", "requiredSkills",
				"jobDescription");

		System.out.println("------  starting of the employer Service test  ------");
		this.mockmvc.perform(MockMvcRequestBuilders.post("/api/employer").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new Gson().toJson(ps))).andExpect(MockMvcResultMatchers.status().isCreated());

		System.out.println("------  endiing of the employer Service test  ------");

	}*/

@Test
	public void managingJobsList() throws Exception {
	PostedJobsList ps = new PostedJobsList("vamsi@gmail.com", "jobTitle", 20L, 5000D, "jobId", "requiredSkills",
			"jobDescription");
		System.out.println("------  starting of the managingJobsList Service test  ------");
/*		this.mockmvc.perform(MockMvcRequestBuilders.get("/api/employer/SE")).andExpect(MockMvcResultMatchers.status().isOk());*/
		this.mockmvc.perform(MockMvcRequestBuilders.post("/api/employer").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new Gson().toJson(ps))).andExpect(MockMvcResultMatchers.status().isCreated());
		System.out.println("------  endiing of the managingJobsList Service test  ------");

	}

}
=======
package com.virtusa.semicolon.employer_service.test;

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
public class EmployerServiceTest {

	MockMvc mockmvc;

	@Autowired
	private WebApplicationContext ac;

	@org.junit.Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(ac).build();
	}
	
	@Test
	public void postingJobServiceTest() throws Exception {
		PostedJobsList ps = new PostedJobsList("vamsi@gmail.com", "jobTitle", 20L, 5000D, "jobId", "requiredSkills",
				"jobDescription");

		System.out.println("------  starting of the employer Service test  ------");
		
		this.mockmvc.perform(MockMvcRequestBuilders.post("/api/employer").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new Gson().toJson(ps))).andExpect(MockMvcResultMatchers.status().isCreated());

		System.out.println("------  ending of the employer Service test  ------");

	}
	

}
>>>>>>> eff3c661e9c768003e1ba6fd7a991ee82e990a76
