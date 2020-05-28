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
	
	/*
	 * @Query(value="select * from item limit 0,10",nativeQuery = true) public
	 * List<Item> getItems();
	 * 
	 * @Query(value =
	 * "select * from item where item_price>=? and item_price<=? and item_manufacture=?"
	 * ,nativeQuery = true) public List<Item>
	 * getItems(@Param("startPrice")BigDecimal
	 * startPrice, @Param("endPrice")BigDecimal endPrice, @Param("manufacture")
	 * String manufacture);
	 */
	/*
	 * @Query(value="select * from item where item_id = ?",nativeQuery = true)
	 * public Item getItem(@Param("item_id")String id);
	 */
	
	@Query(value="select from order where order_username=?")
	public List<Order> getOrdersByName(@Param("order_username")String order_username);
	
	@Query(value="select from order where order_id=?")
	public Order getOrdersById(@Param("order_id")Long order_id);
	
	@Query("select from order where order_status=? and order_username=?")
	@Transactional
	public List<Order> getOrderByStatus(@Param("order_status") OrderStatus order_status, 
			@Param("order_username")String order_username);
	
	@Modifying
	@Query("updte order set order_status=? where order_username=? and order_id=?")
	@Transactional
	public void updateOrderStatus(@Param("order_status") OrderStatus order_status, 
			@Param("order_username")String order_username,
			@Param("order_id")Long order_id);
	
	
}
