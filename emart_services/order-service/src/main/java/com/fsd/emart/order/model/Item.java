package com.fsd.emart.order.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Item {
	
	private Long i_id;
	private String i_name;
	private int i_category_id;
	private int i_subcategory_id;
	private BigDecimal i_price;
	private String i_desc;
	private String i_mft;
	private int i_stock_num;
	private String i_remarks;
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
