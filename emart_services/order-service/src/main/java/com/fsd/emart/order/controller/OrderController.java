package com.fsd.emart.order.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.emart.order.service.OrderServiceImpl;
import com.fsd.emart.order.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderServiceImpl orderService;
	
	@GetMapping("/getMyOrder")
	public List<Order> getMyOrder(@RequestParam(name="username", required=true)String username){
		return orderService.getMyOrder(username);
	}
	
	@PutMapping("/submitOrder")
	public Order submitOrder(@RequestBody Order order) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		order.setO_created_time(date);
		return orderService.submitOrder(order);
	}
	
	@PostMapping("/updateOrder")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.payOrder(order);
	}

}
