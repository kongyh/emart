package com.fsd.emart.cart.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.emart.cart.entity.Item;

/*
 * @Repository public interface ItemRepository extends
 * JpaRepository<Item,Integer>{
 * 
 * @Query(
 * value="delete from item where cart_id=? and item_name=? and item_manufacture=?"
 * ,nativeQuery = true)
 * 
 * @Modifying
 * 
 * @Transactional public void deleteItem(@Param("card_id")Long
 * card_id, @Param("item_name")String
 * item_name, @Param("item_manufacture")String item_manufacture );
 * 
 * 
 * 
 * }
 */

