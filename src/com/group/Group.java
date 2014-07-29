package com.group;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group.member.Member;
import com.user.User;

@Entity
@Table(name="MEMBER_GROUP")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String name;
	
	@OneToOne
	private Member owner;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="group")
	private Set<Member> groupMembers;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="group")
	private Set<Member> sharedLists;
	
	public Group() {
		super();
	}
	
	public Group(String name) {
		super();
		this.name = name;
	}
	
	public Group(String name, Member owner) {
		super();
		this.name = name;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public int getID(){
		return this.ID;
	}

	public Set<Member> getGroupMembers() {
		return groupMembers;
	}
	
	public void addGroupMember(Member member){
		this.groupMembers.add(member);
	}
	
	public void removeGroupMember(Member member){
		this.groupMembers.remove(member);
	}

	
	
}
