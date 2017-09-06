package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.Group;
import com.repositories.GroupRepository;

@Controller
public class GroupController extends BaseController<Group, GroupRepository> {
	
	@Autowired
	public GroupController(GroupRepository repository) {
		super(repository);
	}
	
}
