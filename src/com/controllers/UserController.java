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

import com.entities.User;
import com.entities.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.repositories.UserRepository;

@Controller
@RequestMapping("/Users")
public class UserController extends BaseController<User, UserRepository> {

	@Autowired
	public UserController(UserRepository repository) {
		super(repository);
	}

	// Move to BaseController in the future

	@RequestMapping(method = RequestMethod.GET)
	@JsonView(View.SummaryList.class)
	public @ResponseBody Collection<User> getAll() {
		return getRepository().findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@JsonView(View.Summary.class)
	public @ResponseBody User findById(@PathVariable int id) {
		return getRepository().findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User create(@RequestBody User instance) {
		return getRepository().persist(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable int id) {
		getRepository().deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User update(@PathVariable int id, @RequestBody User instance) {
		return getRepository().updateById(id, instance);
	}

}
