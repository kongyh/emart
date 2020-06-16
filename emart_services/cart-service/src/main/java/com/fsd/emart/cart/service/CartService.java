package com.fsd.emart.cart.service;

import java.util.List;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.entity.Item;

public interface CartService {

	public Cart addInCart(Cart cart) ;
	public void deleteInCart(int i_id);
	public List<Cart> getCart(String username);
	public Cart editInCart(Cart cart);
}
