package com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.User;

@Component
public class UserRepository extends BaseRepository<User>{

	@Autowired
	public UserRepository(Class<User> user) {
		super(user);
	}
}
