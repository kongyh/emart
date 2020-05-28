package com.fsd.emart.user.service;

import com.fsd.emart.user.entity.Buyer;
import com.fsd.emart.user.entity.Seller;
import com.fsd.emart.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.emart.user.Repository.BuyerRepository;
import com.fsd.emart.user.Repository.SellerRepository;
import com.fsd.emart.user.common.RoleType;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BuyerRepository buyerRepository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public Buyer registUser(Buyer buyer) {
		return buyerRepository.saveAndFlush(buyer);
	}
	
	@Override
	public Seller registUser(Seller seller) {
		return sellerRepository.saveAndFlush(seller);
	}

	@Override
	public Object loginUser(User user) {
        User userRes = new User();
		switch(user.getRole()){
		case BUYER:
			Buyer buyer =buyerRepository.loginUser(user.getUsername(), user.getPassword());
			userRes.setUsername(buyer.getB_name());
			userRes.setPassword(buyer.getB_password());
			userRes.setRole(RoleType.BUYER);
			return userRes;
		case SELLER:
			Seller seller =sellerRepository.loginUser(user.getUsername(), user.getPassword());
			userRes.setUsername(seller.getS_name());
			userRes.setPassword(seller.getS_password());
			userRes.setRole(RoleType.SELLER);
			return userRes;
		default:
			return null;
		}

	}

}
