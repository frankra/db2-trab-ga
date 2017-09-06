package com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Item;

@Component
public class ItemRepository extends BaseRepository<Item> {
	
	@Autowired
	public ItemRepository(Class<Item> item){
		super(item);
	}
}
