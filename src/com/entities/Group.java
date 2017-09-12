package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "hgroup")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Group extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String name;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonView(View.Summary.class)
	private Member owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	@JsonView(View.Summary.class)
	@JsonIgnoreProperties({"group"})
	private Set<Member> members;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	@JsonView(View.Summary.class)
	@JsonIgnoreProperties({"group"})
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
