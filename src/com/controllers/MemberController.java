package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.entities.Member;
import com.repositories.MemberRepository;

@Controller
public class MemberController extends BaseController<Member, MemberRepository> {
	
	@Autowired
	public MemberController(MemberRepository repository) {
		super(repository);
	}
	
}
