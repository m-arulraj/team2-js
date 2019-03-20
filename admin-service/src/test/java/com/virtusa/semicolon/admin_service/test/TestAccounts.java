package com.virtusa.semicolon.admin_service.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccounts {
	
	private MockMvc mvc;


	@Autowired
	WebApplicationContext wac;
	
	@org.junit.Before
	public void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	   }
	
	@org.junit.Test
	public void approvalAcceptTest() throws Exception {
		
		this.mvc.perform(put("/api/admin/approval/requests/accept/himasri@gmail.com"))
		 .andExpect(status().isOk());
		
	}
	
}
