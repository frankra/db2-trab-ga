package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

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
	private Member owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Member> groupMembers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<List> groupLists;

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

	public Set<List> getGroupLists() {
		return groupLists;
	}

	public void addGroupList(com.entities.List list) {
		this.groupLists.add(list);
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

	public Set<Member> getGroupMembers() {
		return groupMembers;
	}

	public void addGroupMember(Member member) {
		this.groupMembers.add(member);
	}

	public void removeGroupMember(Member member) {
		this.groupMembers.remove(member);
	}

}
