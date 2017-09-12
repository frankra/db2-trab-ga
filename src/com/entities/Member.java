package com.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "member")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Member extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JsonIgnore
	private Group group;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JsonView(View.Summary.class)
	private User user;


	public Member(Group group, User user) {
		super();
		this.group = group;
		this.user = user;
	
	}

	public Member() {
		super();
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
