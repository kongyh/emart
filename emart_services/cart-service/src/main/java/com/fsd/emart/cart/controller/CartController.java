package com.fsd.emart.cart.controller;

import java.math.BigDecimal;

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
	public Cart getMyCart(@RequestParam(name="username", required=true)String username) {
		return cartService.getCart(username);
	}
	
	@PutMapping("/addCart")
	public Cart addInCart(@RequestBody Item item) {
		return cartService.addInCart(item);
	}
	
	@DeleteMapping("/deleteCart")
	public Cart deleteInCart(@RequestBody Item item) {
		return cartService.removeInCart(item);
	}
	
	@PostMapping("/editInCart")
	public Cart editInCart(@RequestBody Cart cart) {
		return cartService.editInCart(cart);
	}
	

}
