package com.fsd.emart.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.emart.user.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{
	
	@Query(value = "select * from buyer where b_name=? and b_password=? ",nativeQuery = true)
	public Buyer loginUser(@Param("b_name")String name, @Param("b_password")String psd);
	
}