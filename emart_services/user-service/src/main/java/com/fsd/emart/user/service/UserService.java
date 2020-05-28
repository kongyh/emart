package com.fsd.emart.user.service;

import com.fsd.emart.user.entity.Seller;
import com.fsd.emart.user.model.User;
import com.fsd.emart.user.common.RoleType;
import com.fsd.emart.user.entity.Buyer;

public interface UserService {
	public Buyer registUser(Buyer buyer);
	public Seller registUser(Seller seller);
	
	public Object loginUser(User user);
}