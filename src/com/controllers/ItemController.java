package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.Item;
import com.repositories.ItemRepository;

@Controller
public class ItemController extends BaseController<Item, ItemRepository> {
	
	@Autowired
	public ItemController(ItemRepository repository) {
		super(repository);
	}
	
}
