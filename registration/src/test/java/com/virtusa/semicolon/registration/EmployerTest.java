package com.virtusa.semicolon.registration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.semicolon.registration.domain.Authorities;
import com.virtusa.semicolon.registration.domain.Registration;
import com.virtusa.semicolon.registration.resource.RegistrationController;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployerTest {
@Autowired
RegistrationController employeeController;
	@Autowired
WebApplicationContext wac;
	
	MockMvc mockMvc;
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();		
	}
	

	
	@Test
	public void employerTest() throws Exception{
		Registration reg = new Registration();
		Authorities auth = new Authorities();
		auth.setAuthorities("ROLE_JOBSEEKER");
		reg.setUserName("hima@gm.com");
		reg.setPassword("123");
		auth.setUser(reg);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/registration/employer").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(auth))).andExpect(status().isCreated());
				/*MockMvcRget("/")).andExpect(status().isOk()).andExpect(view().name("index"));*/
	}
}
