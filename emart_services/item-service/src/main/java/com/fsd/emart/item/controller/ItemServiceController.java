package com.fsd.emart.item.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.emart.item.service.ItemServiceImpl;
import com.fsd.emart.item.entity.Item;
import com.fsd.emart.item.model.ItemFilter;

@RestController
@RequestMapping("/item")
public class ItemServiceController {
    
	@Autowired ItemServiceImpl itemService;
	
	@GetMapping(value = "/getItems")
	public List<Item> getItems() {
		return itemService.getItems();
	}
	
	@GetMapping(value="/getManufactures")
	public List<String> getManufactures(){
		return itemService.getManufactures();
	}
	
	@GetMapping(value = "/getFilterItems")
	public List<Item> getFilterItems(@RequestParam(name="startPrice", required=true)BigDecimal startPrice,
			@RequestParam(name="endPrice", required=true)BigDecimal endPrice,
			@RequestParam(name="manufacture", required=true)String manufacture) {
		ItemFilter filter = new ItemFilter();
		filter.setItem_start_price(startPrice);
		filter.setItem_end_price(endPrice);
		filter.setItem_manufacture(manufacture);
		return itemService.getitems(filter);
	}
	
	@GetMapping(value = "/getItem")
	public Item getItemByID(@RequestParam(name="i_id", required=true)Integer id) {
		return itemService.getItem(id);
	}
	
	@PostMapping(value="/addItem")
	public Item addItem(@RequestBody Item item) {
		return itemService.insertItem(item);
	}

}
