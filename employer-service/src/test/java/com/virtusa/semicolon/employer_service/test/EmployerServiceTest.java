package com.virtusa.semicolon.employer_service.test;

import static org.junit.Assert.fail;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployerServiceTest {

	MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext ac;
	
	@org.junit.Before
	public void setUp()
	{
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
