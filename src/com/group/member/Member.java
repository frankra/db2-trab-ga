package com.group.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group.Group;
import com.user.User;

@Entity
@Table(name="MEMBER")
public class Member{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Group group;
	@OneToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	public Member(Group group, User user) {
		super();
						
		this.group = group;
		this.user = user;
	}
	
	public Member(){
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
