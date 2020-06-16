package com.fsd.emart.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired 
	CartRepository cartRepository;
	
	/*
	 * @Autowired ItemRepository itemRepository;
	 */
	
    @Override
	public Cart addInCart(Cart cart) {   	
    	return cartRepository.saveAndFlush(cart);
	}

	@Override
	public void deleteInCart(int i_id) {
		cartRepository.deleteInCart(i_id);
	}

	@Override
	public List<Cart> getCart(String username) {
		return cartRepository.getCart(username);
	}

	@Override
	public Cart editInCart(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

}
