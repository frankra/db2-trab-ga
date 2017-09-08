package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "hgroup")
public class Group extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String name;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Member owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	@JsonManagedReference	
	private Set<Member> members;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	//@JsonManagedReference
	@JsonIgnore
	private Set<List> lists;

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

	public Set<List> getLists() {
		return lists;
	}

	public void addList(com.entities.List list) {
		this.lists.add(list);
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

	public Set<Member> getMembers() {
		return members;
	}

	public void addMember(Member member) {
		this.members.add(member);
	}

	public void removeMember(Member member) {
		this.members.remove(member);
	}

}
