package com.group.member;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.group.Group;
import com.user.User;

@Entity
public class Member extends User{
	@Id
	private String memberUUID;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="groupUUID")
	private Group group;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="userUUID")
	private User user;
	
	public Member(Group group, User user) {
		super();
		this.memberUUID = UUID.randomUUID().toString();				
		this.group = group;
		this.user = user;
	}
	
	public Member(){
		super();
		this.memberUUID = UUID.randomUUID().toString();	
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
