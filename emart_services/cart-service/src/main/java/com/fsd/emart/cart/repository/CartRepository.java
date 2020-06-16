package com.fsd.emart.cart.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsd.emart.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	
	@Query(value="select * from cart where username=?",nativeQuery = true)
	public List<Cart> getCart(@Param("username")String username);
    
	@Modifying@Transactional
	@Query(value="delete from cart where i_id=?",nativeQuery = true)
	public void deleteInCart(@Param("i_id")int i_id);
	
	@Modifying@Transactional
	@Query(value="delete from cart where username=?",nativeQuery = true)
	public void clearCart(@Param("username")String username);
}
