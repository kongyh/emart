package com.fsd.emart.cart.service;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.entity.Item;

public interface CartService {

	public Cart addInCart(Item item) ;
	public Cart removeInCart(Item item);
	public Cart getCart(String username);
	public Cart editInCart(Cart cart);
}
