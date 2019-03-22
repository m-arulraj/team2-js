
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
import com.virtusa.semicolon.employer_service.domain.CompanyDetails;
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
	public void employerServiceTest() throws Exception {
		PostedJobsList ps = new PostedJobsList("vamsi@gmail.com", "jobTitle", 20L, 5000D, "jobId", "requiredSkills",
				"jobDescription", "IT");

		System.out.println("------  starting of the employer Service test  ------");

		this.mockmvc.perform(MockMvcRequestBuilders.post("/api/employer").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new Gson().toJson(ps))).andExpect(MockMvcResultMatchers.status().isCreated());

		System.out.println("------  endiing of the employer Service test  ------");

	}

	@Test
	public void managingJobsList() throws Exception {
		PostedJobsList ps = new PostedJobsList("vamsi@gmail.com", "jobTitle", 20L, 5000D, "jobId", "requiredSkills",
				"jobDescription", "IT");
		System.out.println("------  starting of the managingJobsList Service test  ------");
		this.mockmvc
				.perform(MockMvcRequestBuilders.put("/api/employer/managingJobs/1212SE")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(new Gson().toJson(ps)))
				.andExpect(MockMvcResultMatchers.status().isOk());
		System.out.println("------  endiing of the managingJobsList Service test  ------");

	}
	
	@Test
	public void updatingEmployerDetails() throws Exception {
	CompanyDetails companyDetails=new CompanyDetails("Wipro",12343232789L,"Chennai","2012-04-20");
		System.out.println("------  starting of the updatingEmployerDetails Service test  ------");
		this.mockmvc
				.perform(MockMvcRequestBuilders.put("/api/employer/companyDetails/vamsi@gmail.com")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(new Gson().toJson(companyDetails)))
				.andExpect(MockMvcResultMatchers.status().isOk());
		System.out.println("------  ending of the updatingEmployerDetails Service test  ------");

	}
	
}
