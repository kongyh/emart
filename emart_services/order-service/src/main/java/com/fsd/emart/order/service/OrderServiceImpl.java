package com.fsd.emart.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsd.emart.order.entity.Order;
import com.fsd.emart.order.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getMyOrder(String username) {
		return orderRepository.getOrdersByName(username);
	}

	@Override
	public Order submitOrder(Order order) {
		return orderRepository.saveAndFlush(order);
	}

	@Override
	public Order payOrder(Order order) {
		orderRepository.updateOrderStatus(order.getOrder_status(), order.getOrder_username(), order.getOrder_id());
		return orderRepository.getOrdersById(order.getOrder_id());
	}

}
