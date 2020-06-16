package com.fsd.emart.cart.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.emart.cart.entity.Cart;
import com.fsd.emart.cart.entity.Item;
import com.fsd.emart.cart.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartServiceImpl cartService;
	
	@GetMapping("/myCart")
	public List<Cart> getMyCart(@RequestParam(name="username", required=true)String username) {
		return cartService.getCart(username);
	}
	
	@PutMapping("/addCart")
	public Cart addInCart(@RequestBody Cart cart) {
		return cartService.addInCart(cart);
	}
	
	@DeleteMapping("/deleteInCart")
	public void deleteInCart(@RequestParam(name="i_id", required=true)String id) {
		int i_id = Integer.parseInt(id);
		cartService.deleteInCart(i_id);
	}
	
	@PostMapping("/editInCart")
	public Cart editInCart(@RequestBody Cart cart) {
		return cartService.editInCart(cart);
	}
	

}
