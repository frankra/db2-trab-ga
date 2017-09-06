package com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Member;

@Component
public class MemberRepository extends BaseRepository<Member> {

	@Autowired
	public MemberRepository(Class<Member> member) {
		super(member);
	}

	
}
