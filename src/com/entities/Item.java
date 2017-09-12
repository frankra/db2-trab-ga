package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "listitem")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	@JsonView(View.Summary.class)
	private String text;
	@Column
	@JsonView(View.Summary.class)
	private boolean done;

	@Column
	@JsonView(View.Summary.class)
	private Date due;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private List list;

	@OneToOne
	@JoinColumn
	@JsonIgnoreProperties({"group"})
	@JsonView(View.Summary.class)
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
