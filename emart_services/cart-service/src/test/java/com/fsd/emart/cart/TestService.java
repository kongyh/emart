package com.fsd.emart.cart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.entity.Item;
import com.fsd.emart.cart.service.CartServiceImpl;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestService {

	@Autowired
	CartServiceImpl cartService;

	@Test
	public void testSave() {
		/*
		 * Cart cart = new Cart(); cart.setUsername("nina");
		 * 
		 * Item item1 = new Item(); item1.setI_name("item1"); item1.setI_price(new
		 * BigDecimal(1000)); item1.setI_mft("taobao"); item1.setI_stock_num(20);
		 * item1.setCart(cart);
		 * 
		 * Item item2 = new Item(); item2.setI_name("item2"); item2.setI_price(new
		 * BigDecimal(2000)); item2.setI_mft("jingdong"); item2.setI_stock_num(20);
		 * item2.setCart(cart);
		 * 
		 * cartService.addInCart(item1); cartService.addInCart(item2);
		 */
	}
	
	@Test
	public void testDelete() {
		
		Cart cart = new Cart();
		cart.setUsername("kkkk");
		Integer car_id = 1;
		/* cart.setCart_id(car_id.longValue()); */
		
		/*
		 * Item item1 = new Item(); item1.setI_name("item1"); item1.setI_price(new
		 * BigDecimal(1000)); item1.setI_mft("taobao"); item1.setI_stock_num(20);
		 * item1.setCart(cart);
		 */

		/* cartService.removeInCart(item1); */
		
	}
	
	@Test
	public void testGet() {
		System.out.println(cartService.getCart("kkkk"));
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
