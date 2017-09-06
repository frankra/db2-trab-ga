package com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.List;

@Component
public class ListRepository extends BaseRepository<List> {

	@Autowired
	public ListRepository(Class<List> list) {
		super(list);
	}
}
