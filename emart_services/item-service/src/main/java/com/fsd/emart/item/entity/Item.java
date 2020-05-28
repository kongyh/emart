package com.fsd.emart.item.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long i_id;
	private int i_category_id;
	private int i_subcategory_id;
	@Column(nullable = false)
	private BigDecimal i_price;
	private String i_desc;
	@Column(nullable = false)
	private String i_mft;
	@Column(nullable = false)
	private Integer i_stock_num;
	private String i_remarks;
	
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
