package com.fsd.emart.user.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fsd.emart.user.Repository.BuyerRepository;
import com.fsd.emart.user.Repository.SellerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestUserRepository {
	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	SellerRepository sellerRepository;
	
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
