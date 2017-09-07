package com.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.entities.Group;
import com.entities.Member;
import com.entities.User;
import com.repositories.GroupRepository;
import com.repositories.ItemRepository;
import com.repositories.ListRepository;
import com.repositories.MemberRepository;
import com.repositories.UserRepository;

@Controller
@RequestMapping("/DemoUtils")
public class DemoUtilsController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private ListRepository listRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(value="/cleanup", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void cleanup(){
		itemRepository.deleteAll();
		listRepository.deleteAll();
		memberRepository.deleteAll();
		groupRepository.deleteAll();
		userRepository.deleteAll();
	}
	
	@RequestMapping(value="/bootstrap", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void bootstrap(){
		this.cleanup();
		
		//Create 3 users
		//Create 2 groups
		//Create 3 lists (2 shared with group)
		//create 3 items for each list
		
		Object[] users = this.createUsers(3).toArray();
		
		User user1 = (User) users[0];
		User user2 =  (User) users[1];
		
		Group group1 = new Group("Group1");
		Group group2 = new Group("Group2");
		groupRepository.persist(group2);
		groupRepository.persist(group1);
		
		//Group1 = {User1, User3}
		Member user1group1 = new Member(group1, user1);
		Member user3group1 = new Member(group1,  (User) users[2]);
		group1.setOwner(user1group1);
		memberRepository.persist(user1group1);
		memberRepository.persist(user3group1);
		groupRepository.merge(group1);
		
		//Group2 = {User2, User3}
		Member user2group2 = new Member(group2, user2);
		Member user3group2 = new Member(group2,  (User) users[2]);
		group2.setOwner(user2group2);
		memberRepository.persist(user2group2);
		memberRepository.persist(user3group2);
		groupRepository.merge(group2);
		
		
	}
	
	private Collection<User> createUsers(int count){
		Collection<User> collection = new ArrayList<User>();
		User iterator;
		for (int i = 0; i < count; i++) {
			iterator = new User(//
				"user" + i,
				"test",
				"test.user" + i + "@mail.com",
				"testuser" + i,
				"dummyPwd"
			);
			userRepository.persist(iterator);
			collection.add(iterator);
		}
		return collection;
	}
	
	
	
	
}
