package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.User;
import com.repositories.UserRepository;

@Controller("/User")
public class UserController extends BaseController<User, UserRepository> {
	
	@Autowired
	public UserController(UserRepository repository) {
		super(repository);
	}
	
}
