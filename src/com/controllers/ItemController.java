package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Item;
import com.repositories.ItemRepository;

@Controller
@RequestMapping("/Itens")
public class ItemController extends BaseController<Item, ItemRepository> {
	
	@Autowired
	public ItemController(ItemRepository repository) {
		super(repository);
	}
	
}
