package com.controllers;

import org.springframework.stereotype.Controller;

import com.entities.BaseEntity;
import com.repositories.BaseRepository;

@Controller
public abstract class BaseController<E extends BaseEntity, Q extends BaseRepository<E>> {

	private Q repository;

	public BaseController(Q repository) {
		this.repository = repository;
	}

	public Q getRepository() {
		return repository;
	}

	public void setRepository(Q repository) {
		this.repository = repository;
	}

	/*
	 * Refactor later on
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public @ResponseBody
	 * Collection<E> getAll(){ return repository.findAll(); }
	 * 
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 * public @ResponseBody E findById(@PathVariable int id) { return
	 * repository.findById(id); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public @ResponseBody E
	 * create(@RequestBody E instance) { return repository.persist(instance); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 * 
	 * @ResponseStatus(HttpStatus.OK) public @ResponseBody void delete(@PathVariable
	 * int id) { repository.deleteById(id); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 * 
	 * @ResponseStatus(HttpStatus.OK) public @ResponseBody E update(@PathVariable
	 * int id, @RequestBody E instance) { return repository.updateById(id,
	 * instance); }
	 */

}
