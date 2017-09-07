package com.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.BaseEntity;
import com.repositories.BaseRepository;

@Controller
public abstract class BaseController <E extends BaseEntity, Q extends BaseRepository<E>> {

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
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<E> getAll(){
		return repository.findAll();
	}
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<E> getAll(){
		return repository.findAll();
	}
	@RequestMapping(value = "/:id", method = RequestMethod.GET)
	public E findById(@RequestParam("id") int id){
		return repository.findById(id);
	}
	
	
	public void deleteById(){}
	
	public E create(){}
	
	public E update(){}*/
	
	
	
}
