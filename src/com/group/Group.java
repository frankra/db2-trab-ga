package com.group;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
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
	@OneToMany(fetch=FetchType.LAZY, mappedBy="group", cascade=CascadeType.PERSIST)
	private Set<Member> groupMembers;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="group", cascade=CascadeType.PERSIST)
	private Set<Member> sharedLists;
	
	/**/
	@Column 
	private Timestamp lastChangedOn;
	@OneToOne
	private Member lastChangedBy;
	@Column
	private Timestamp createdOn;
	@OneToOne
	private Member createdBy;
	/**/
	
	public Group() {
		super();
	}
	
	public Group(String name) {
		super();
		this.name = name;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	}
	
	public Group(String name, Member owner) {
		super();
		this.name = name;
		this.owner = owner;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.createdBy = owner;
		this.lastChangedOn = this.createdOn;
		this.lastChangedBy = owner;
	}

	
	public Timestamp getLastChangedOn() {
		return lastChangedOn;
	}

	public void setLastChangedOn(Timestamp lastChangedDate) {
		this.lastChangedOn = lastChangedDate;
	}

	public Member getLastChangedBy() {
		return lastChangedBy;
	}

	public void setLastChangedBy(Member lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	public Set<Member> getSharedLists() {
		return sharedLists;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public Member getCreatedBy() {
		return createdBy;
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
