package com.fsd.emart.cart.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long i_id;
	@Column(nullable = false)
	private String i_name;
	private int i_category_id;
	private int i_subcategory_id;
	@Column(nullable = false)
	private BigDecimal i_price;
	private String i_desc;
	@Column(nullable = false)
	private String i_mft;
	@Column(nullable = false)
	private int i_stock_num;
	private String i_remarks;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	private int i_quantity = 1;
	
	@Override
	public String toString(){
		return "Item{"+
	           "i_id:"+i_id+
	           ",i_category_id:"+i_category_id+
	           ",i_subcategory_id:"+i_subcategory_id+
	           ",i_mft:"+i_mft+
	           "}";   
	}

}
