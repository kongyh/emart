package com.fsd.emart.order.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fsd.emart.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestOrderService {
	@Autowired
	OrderService orderService;
	
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
