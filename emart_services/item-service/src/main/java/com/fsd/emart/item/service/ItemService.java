package com.fsd.emart.item.service;

import java.util.List;

import com.fsd.emart.item.entity.Item;
import com.fsd.emart.item.model.ItemFilter;

public interface ItemService {

	public List<Item> getItems();
	public List<Item> getitems(ItemFilter filter);
	public Item getItem(Integer id);
	public Item insertItem(Item item);
	public List<String> getManufactures();

}
