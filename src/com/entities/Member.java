package com.entities;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "member")
public class Member {
	@Id
	private int ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JsonBackReference
	private Group group;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private User user;

	/**/
	@Column
	private Timestamp lastChangedOn;
	@Column
	private Timestamp createdOn;
	/**/

	public Member(Group group, User user) {
		super();
		this.ID = this.fetchCompositeKey(group.getID(), user.getID());
		this.group = group;
		this.user = user;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	}

	public Member() {
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

	public int getID() {
		return this.ID;
	}

	private int fetchCompositeKey(int groupID, int userID) {
		int composedID = groupID + userID;
		return composedID;
	};

	public void setID(int iD) {
		ID = iD;
	}

}
