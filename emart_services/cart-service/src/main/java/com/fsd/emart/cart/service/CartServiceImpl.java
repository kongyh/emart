package com.fsd.emart.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.entity.Item;
import com.fsd.emart.cart.repository.CartRepository;
import com.fsd.emart.cart.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired 
	CartRepository cartRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
    @Override
	public Cart addInCart(Item item) {   	
    	//Cart cart = cartRepository.getCart(item.getCart().getUsername());
    	Cart cart = item.getCart();
    	List<Item> itemArr = new ArrayList<Item>();
    	itemArr.add(item);
		cart.setList(itemArr);
		return cartRepository.saveAndFlush(cart);
//    	if(cart==null) {
//    		cart = item.getCart();
//    		cart.setList(itemArr);
//    		return cartRepository.saveAndFlush(cart);
//    	}else {
//    		itemRepository.save(item);
//    		return cart;
//    	}
	}

	@Override
	public Cart removeInCart(Item item) {
		itemRepository.deleteItem(item.getCart().getCart_id(),item.getI_name(),item.getI_mft());
		return this.getCart(item.getCart().getUsername());
	}

	@Override
	public Cart getCart(String username) {
		return cartRepository.getCart(username);
	}

	@Override
	public Cart editInCart(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}

}
