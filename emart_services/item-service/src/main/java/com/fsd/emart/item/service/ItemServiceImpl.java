package com.fsd.emart.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fsd.emart.item.entity.Item;
import com.fsd.emart.item.model.ItemFilter;
import com.fsd.emart.item.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
	
	@Override
	public List<Item> getItems() {
		List<Item> list = itemRepository.getItems();
		return list;
	}
	
	@Override
	public List<String> getManufactures(){
		List<String> list = itemRepository.getManufactures();
		return list;
	}

	@Override
	public List<Item> getitems(ItemFilter filter) {
		List<Item> list  = itemRepository.getFilterItems(filter.getItem_start_price(), filter.getItem_end_price(), filter.getItem_manufacture());
		return list;
	}

	@Override
	public Item getItem(Integer id) {
		Item item = itemRepository.getItemById(id.longValue());
		if(item!=null){
		    return item;
		}else {
		    return null;
		}
	}

	@Override
	public Item insertItem(Item item) {
		return itemRepository.saveAndFlush(item);
	}

}
