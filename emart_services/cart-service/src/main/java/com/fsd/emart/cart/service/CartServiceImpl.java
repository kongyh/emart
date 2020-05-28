package com.fsd.emart.cart.service;

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
    	Cart cart = cartRepository.getCart(item.getCart().getUsername());
    	item.setCart(cart);
    	List<Item> itemList= cart.getList();
    	itemList.add(item);
    	cart.setList(itemList);
		/* itemRepository.save(item); */
		return cartRepository.saveAndFlush(cart);
		
	}

	@Override
	public Cart removeInCart(Item item) {
		itemRepository.deleteItem(item.getCart().getCart_id(),item.getItem_name(),item.getItem_manufacture());
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
