package com.list;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="list", cascade=CascadeType.PERSIST)
	private Set<Item> items = new HashSet<Item>();
	
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
	
	public List(String name, Group group, Member member) {
		super();
		this.name = name;
		this.group = group;
		this.member = member;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.createdBy = member;
		this.lastChangedOn = this.createdOn;
		this.lastChangedBy = member;
	}
	
	public List() {
		super();
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Timestamp getLastChangedOn() {
		return lastChangedOn;
	}
	public void setLastChangedOn(Timestamp lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}
	public Member getLastChangedBy() {
		return lastChangedBy;
	}
	public void setLastChangedBy(Member lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}
	public int getID() {
		return ID;
	}
	public Group getGroup() {
		return group;
	}
	public Set<Item> getItems() {
		return items;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public Member getCreatedBy() {
		return createdBy;
	}
	public void addItem(Item item){
		this.items.add(item);
	}
	
	
}
