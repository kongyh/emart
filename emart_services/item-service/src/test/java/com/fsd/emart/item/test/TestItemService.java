package com.fsd.emart.item.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fsd.emart.item.entity.Item;
import com.fsd.emart.item.service.ItemServiceImpl;


public class TestItemService extends TestTemplate {
	@Autowired ItemServiceImpl itemService;
	
	@Test
	public void testGetItems() {
		List<Item> itemList = itemService.getItems();
		for (Item item : itemList) {
			System.out.println(item.toString());
			//Assert.assertSame
			//
		}
	}
   
}