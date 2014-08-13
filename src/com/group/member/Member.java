package com.group.member;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable=false)
	private Group group;
	@OneToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	/**/
	@Column 
	private Timestamp lastChangedOn;
	@Column
	private Timestamp createdOn;
	/**/
	
	public Member(Group group, User user) {
		super();
						
		this.group = group;
		this.user = user;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	}
	
	public Member(){
		super();
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
			
	}

	public Timestamp getLastChangedOn() {
		return lastChangedOn;
	}

	public void setLastChangedOn(Timestamp lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
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
	
	public int getID(){
		return this.ID;
	}
	
}
