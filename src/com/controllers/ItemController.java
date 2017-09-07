package com.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.entities.Item;
import com.repositories.ItemRepository;

@Controller
@RequestMapping("/Items")
public class ItemController extends BaseController<Item, ItemRepository> {

	@Autowired
	public ItemController(ItemRepository repository) {
		super(repository);
	}

	// Move to BaseController in the future

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Item> getAll() {
		return getRepository().findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Item findById(@PathVariable int id) {
		return getRepository().findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Item create(@RequestBody Item instance) {
		return getRepository().persist(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable int id) {
		getRepository().deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Item update(@PathVariable int id, @RequestBody Item instance) {
		return getRepository().updateById(id, instance);
	}
}
