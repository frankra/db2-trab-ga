package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.User;
import com.repositories.UserRepository;

@Controller
@RequestMapping("/Users")
public class UserController extends BaseController<User, UserRepository> {
	
	@Autowired
	public UserController(UserRepository repository) {
		super(repository);
	}
	
}
