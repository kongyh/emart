package com.fsd.emart.order.entity;

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
	private Long item_id;
	@Column(nullable = false)
	private String item_name;
	private String item_category;
	private String item_subCatetory;
	@Column(nullable = false)
	private BigDecimal item_price;
	private String item_desc;
	@Column(nullable = false)
	private String item_manufacture;
	@Column(nullable = false)
	private int item_stock_number;
	private String item_remarks;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
	private Order order;
	private int item_quantity = 1;
	
	@Override
	public String toString(){
		return "Item{"+
	           "item_id:"+item_id+
	           ",item_category:"+item_category+
	           ",item_subCatetory:"+item_subCatetory+
	           ",item_manufacture:"+item_manufacture+
	           "}";   
	}

}
