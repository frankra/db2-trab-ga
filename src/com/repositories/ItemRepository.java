package com.repositories;

import org.springframework.stereotype.Component;

import com.entities.Item;

@Component
public class ItemRepository extends BaseRepository<Item> {

	public ItemRepository() {
		super(Item.class);
	}
}
