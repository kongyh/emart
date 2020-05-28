package com.fsd.emart.cart.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.emart.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	
	@Query(value="select * from cart where username=?",nativeQuery = true)
	public Cart getCart(@Param("username")String username);

	
}
