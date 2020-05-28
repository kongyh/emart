package com.fsd.emart.item.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.emart.item.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{
	
	@Query(value="select * from item limit 0,10",nativeQuery = true)
	public List<Item> getItems();
	
	//@Query(value = "select * from item where i_price>=0 and i_price<=3000 and i_mft='Tisso' ",nativeQuery = true)
	@Query(value = "select * from item where i_price>=?1 and i_price<=?2 and i_mft=?3 ",nativeQuery = true)
	public List<Item> getFilterItems(BigDecimal startPrice, BigDecimal endPrice,String manufacture);
	
	/*
	 * @Query(value="select * from item where item_id = ?",nativeQuery = true)
	 * public Item getItem(@Param("item_id")String id);
	 */
	
	@Query(value="select distinct i_mft from item",nativeQuery = true)
	public List<String> getManufactures();
	
	
	
}



