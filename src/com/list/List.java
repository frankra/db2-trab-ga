package com.list;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.group.Group;
import com.group.member.Member;
import com.list.item.Item;


@Entity
public class List {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String name;
	
	@ManyToOne
	private Group group;
	
	@OneToOne
	private Member member;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="list")
	private Set<Item> items;
	
	
	
	
}
