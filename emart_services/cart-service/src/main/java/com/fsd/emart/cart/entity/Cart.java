package com.fsd.emart.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cart_id; 
	private String username;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Item> list;
	
	@Override
	public String toString() {
		return "cart:{"+
	           "cart_id:"+cart_id+
	           ",username:"+username+
	           ",itemLIst:"+list.toString()+
	           "}";
	}

}
