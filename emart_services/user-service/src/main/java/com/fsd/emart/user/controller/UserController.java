package com.fsd.emart.user.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.emart.user.service.UserServiceImpl;
import com.fsd.emart.user.common.Result;
import com.fsd.emart.user.entity.Buyer;
import com.fsd.emart.user.entity.Seller;
import com.fsd.emart.user.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	 @PostMapping(value = "/buyerSignup")
	 public ResponseEntity<Buyer> signup(@RequestBody Buyer buyer) {
		    System.out.println("got post request for /user/buyerSignup, and role is: buyer");
		    long time = System.currentTimeMillis();
		    Date date = new Date(time);
		    buyer.setB_created_time(date);
		    Buyer  savedBuyer = userService.registUser(buyer);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuyer); 
	    }
	 
	 @PostMapping(value = "/sellerSignup")
	 public ResponseEntity<Seller> signup(@RequestBody Seller seller) {
		    System.out.println("got post request for /user/sellerSignup, and role is: seller");   
		    long time = System.currentTimeMillis();
		    Date date = new Date(time);
		    seller.setSeller_created_time(date);
		    Seller  savedSeller = userService.registUser(seller);
		    return ResponseEntity.status(HttpStatus.CREATED).body(savedSeller); 
	    }
	 
	 @PostMapping(value="/login")
	 public Result<User> login(@RequestBody User user){
		    System.out.println("got post request for /user/login, and role is:"+user.getRole());   
		    User  savedUser = (User)userService.loginUser(user);
		    Result<User> result = new Result<>();
		    if(savedUser!=null) {
		    	result.setData(savedUser);
		    }else {
		    	result.setCode(401);
		    	result.setMessage("failed");
		    }
	        
	        return result;
	 }
	 
	 
	 
	 

}
