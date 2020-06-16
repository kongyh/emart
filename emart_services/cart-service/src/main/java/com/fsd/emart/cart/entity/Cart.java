package com.fsd.emart.cart.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	private Long i_id; 
	private String username;
	/*
	 * @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch =
	 * FetchType.EAGER) private List<Item> list;
	 */
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
	private int i_quantity = 1;
	
	@Override
	public String toString() {
		return "cart:{"+
	           "i_id:"+i_id+
	           ",username:"+username+
	           ",itemLIst:"+//list.toString()+
	           "}";
	}

}
