package com.fsd.emart.order.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsd.emart.order.common.OrderStatus;
import com.fsd.emart.order.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	@Query(value="select * from user_order where o_username=?",nativeQuery = true)
	public List<Order> getOrdersByName(@Param("username")String username);
	
	/*
	 * @Query(value="select * from user_order where order_id=?",nativeQuery = true)
	 * public Order getOrdersById(@Param("order_id")Long order_id);
	 * 
	 * @Query(
	 * value="select * from user_order where order_status=? and order_username=?"
	 * ,nativeQuery = true)
	 * 
	 * @Transactional public List<Order> getOrderByStatus(@Param("order_status")
	 * OrderStatus order_status,
	 * 
	 * @Param("order_username")String order_username);
	 */
	
	@Modifying
	@Query(value="updte order set order_status=? where order_username=? and order_id=?",nativeQuery = true)
	@Transactional
	public void updateOrderStatus(@Param("order_status") OrderStatus order_status, 
			@Param("order_username")String order_username,
			@Param("order_id")Long order_id);
	
	
}


