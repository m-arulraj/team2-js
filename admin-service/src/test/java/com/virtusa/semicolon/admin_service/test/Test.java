package com.virtusa.semicolon.admin_service.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.virtusa.semicolon.admin_service.controller.AdminController;
import com.virtusa.semicolon.admin_service.domain.User;
import com.virtusa.semicolon.admin_service.service.AdminService;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

	private MockMvc mvc;
	
	@InjectMocks
	AdminController adminController;
	
	@Mock
	AdminService adminService;
	
	@Autowired
	WebApplicationContext wac;

	@org.junit.Before
	public void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	   }
	
	@org.junit.Test
	public void approvalTest() throws Exception {
		 List<User> users = Arrays.asList(
		            new User("s@ok.com","123",0L),
		            new User("a@ok.com","123",0L));
		 
		 
		 
		String s =this.mvc.perform(get("/api/admin/approval/requests"))
		 .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
         .andReturn().getResponse().getContentAsString();
         
         
         System.out.println(s);
	
	}
	
	
	@org.junit.Test
	public void approvalAcceptTest() throws Exception {
		this.mvc.perform(put("/api/admin/approval/requests/accept/himasri@gmail.com"))
		 .andExpect(status().isOk());
	}
	
	
}
