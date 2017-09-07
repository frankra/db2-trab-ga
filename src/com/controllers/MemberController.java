package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Member;
import com.repositories.MemberRepository;

@Controller
@RequestMapping("/Members")
public class MemberController extends BaseController<Member, MemberRepository> {
	
	@Autowired
	public MemberController(MemberRepository repository) {
		super(repository);
	}
	
}
