package com.fsd.emart.user.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fsd.emart.user.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestUserService {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testSubmit() {
		
	}
	
	@Before
	public void init() {
		System.out.println("test begin-----------------");
	}

	@After
	public void after() {
		System.out.println("test end-----------------");
	}

}
