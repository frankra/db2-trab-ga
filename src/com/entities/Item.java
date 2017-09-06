package com.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "listitem")
public class Item extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public Item(String text, Date due, List list, Member owner) {
		super();
		this.text = text;
		this.due = due;
		this.list = list;
		this.owner = owner;
	}

	public Item(String name, List list, Member owner) {
		super();
		this.text = name;
		this.list = list;
		this.owner = owner;
	}

	public Item() {
		super();
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

	public void setDue(Date due) {
		this.due = due;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public List getList() {
		return list;
	}

}
