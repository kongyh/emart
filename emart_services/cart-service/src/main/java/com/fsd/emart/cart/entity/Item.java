package com.fsd.emart.cart.entity;

import java.math.BigDecimal;

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
	private String i_category;
	private String i_subCatetory;
	@Column(nullable = false)
	private BigDecimal i_price;
	private String i_desc;
	@Column(nullable = false)
	private String i_manufacture;
	@Column(nullable = false)
	private int i_stock_number;
	private String i_remarks;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	private int i_quantity = 1;
	
	@Override
	public String toString(){
		return "Item{"+
	           "i_id:"+i_id+
	           ",i_category:"+i_category+
	           ",i_subCatetory:"+i_subCatetory+
	           ",i_manufacture:"+i_manufacture+
	           "}";   
	}

}
