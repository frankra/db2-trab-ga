package com.repositories;

import org.springframework.stereotype.Component;

import com.entities.User;

@Component
public class UserRepository extends BaseRepository<User> {

	public UserRepository() {
		super(User.class);
	}
}
