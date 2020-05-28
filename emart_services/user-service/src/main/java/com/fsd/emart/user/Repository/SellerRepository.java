package com.fsd.emart.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.emart.user.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	
	@Query(value = "select * from seller where s_name=? and s_password=? ",nativeQuery = true)
	public Seller loginUser(@Param("s_name")String name, @Param("s_password")String psd);
	
}
