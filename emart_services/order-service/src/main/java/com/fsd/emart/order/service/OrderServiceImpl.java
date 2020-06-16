package com.fsd.emart.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.emart.order.entity.Order;
import com.fsd.emart.order.repository.OrderRepository;

@Service
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
//		orderRepository.updateOrderStatus(order.getO_status(), order.getO_username(), order.getO_id());
//		return orderRepository.getOrdersById(order.getO_id());
		return null;
	}

}
