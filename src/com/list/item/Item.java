package com.list.item;

import java.sql.Date;
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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import com.group.member.Member;
import com.list.List;

@Entity
@Table(name="listitem")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String text;
	@Column
	private boolean done;
	

	@Column
	private Date due;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn
	@JsonBackReference
	private List list;
	
	@OneToOne
	@JoinColumn
	@JsonBackReference
	private Member owner;
	
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
	public Item(String text, Date due, List list, Member owner) {
		super();
		this.text = text;
		this.due = due;
		this.list = list;
		this.owner = owner;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.createdBy = owner;
		this.lastChangedOn = this.createdOn;
		this.lastChangedBy = owner;
	}
	
	public Item(String name, List list, Member owner) {
		super();
		this.text = name;
		this.list = list;
		this.owner = owner;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.createdBy = owner;
		this.lastChangedOn = this.createdOn;
		this.lastChangedBy = owner;
	}
	
	public Item(){
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Date getDue() {
		return due;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public void setDue(Date due) {
		this.due = due;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
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

	public List getList() {
		return list;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public Member getCreatedBy() {
		return createdBy;
	};
	
	
}
