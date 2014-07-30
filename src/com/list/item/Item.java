package com.list.item;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import com.group.member.Member;
import com.list.List;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String name;
	private boolean done;

	private Date createdOn;

	private Date due;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private List list;
	
	@OneToOne
	private Member owner;
	
	
}
