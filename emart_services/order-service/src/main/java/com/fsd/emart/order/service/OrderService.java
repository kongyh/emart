package com.fsd.emart.order.service;

import java.util.List;
import com.fsd.emart.order.entity.Order;

public interface OrderService {

	public List<Order> getMyOrder(String username);
	public Order submitOrder(Order order);
	public Order payOrder(Order order);
	

}
