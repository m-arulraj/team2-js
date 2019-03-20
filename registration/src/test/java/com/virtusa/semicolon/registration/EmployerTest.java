package com.virtusa.semicolon.registration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployerTest {
/*@Autowired
EmployeeController employeeController;*/
	@Autowired
WebApplicationContext wac;
	
	MockMvc mockMvc;
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();		
	}
	@Test
	public void employerTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
				/*MockMvcRget("/")).andExpect(status().isOk()).andExpect(view().name("index"));*/
	}
}
