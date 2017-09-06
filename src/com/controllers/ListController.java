package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.List;
import com.repositories.ListRepository;

@Controller
public class ListController extends BaseController<List, ListRepository> {
	
	@Autowired
	public ListController(ListRepository repository) {
		super(repository);
	}
	
}
