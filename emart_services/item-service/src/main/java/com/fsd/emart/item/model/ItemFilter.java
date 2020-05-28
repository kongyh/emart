package com.fsd.emart.item.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemFilter {
	private BigDecimal item_start_price;
	private BigDecimal item_end_price;
	private String item_manufacture;

}
