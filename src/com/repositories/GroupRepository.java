package com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Group;

@Component
public class GroupRepository extends BaseRepository<Group> {
	
	@Autowired
	public GroupRepository(Class<Group> group){
		super(group);
	}
}
