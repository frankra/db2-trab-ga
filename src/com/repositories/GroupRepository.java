package com.repositories;

import org.springframework.stereotype.Component;

import com.entities.Group;

@Component
public class GroupRepository extends BaseRepository<Group> {
	
	public GroupRepository(){
		super(Group.class);
	}
}
