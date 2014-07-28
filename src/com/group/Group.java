package com.group;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.group.member.Member;
import com.user.User;

@Entity
public class Group {
	@Id
	private String groupUUID;
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="OWNER_ID")
	private Member owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="GROUP_ID")
	private List<Member> groupMembers;
	
	
	public Group() {
		super();
		this.groupUUID = UUID.randomUUID().toString();
	}
	
	public Group(String name, Member owner) {
		super();
		this.groupUUID = UUID.randomUUID().toString();
		this.name = name;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	
	
}
