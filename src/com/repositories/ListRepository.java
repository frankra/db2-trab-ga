package com.repositories;

import org.springframework.stereotype.Component;

import com.entities.List;

@Component
public class ListRepository extends BaseRepository<List> {

	public ListRepository() {
		super(List.class);
	}
}
