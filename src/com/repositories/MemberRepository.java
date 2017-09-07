package com.repositories;

import org.springframework.stereotype.Component;

import com.entities.Member;

@Component
public class MemberRepository extends BaseRepository<Member> {

	public MemberRepository() {
		super(Member.class);
	}

}
