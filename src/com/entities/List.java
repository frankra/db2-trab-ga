package com.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "list")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class List extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	@JsonView(View.Summary.class)
	private String name;

	@ManyToOne
	@JoinColumn
	@JsonView(View.Summary.class)
	private Group group;

	@OneToOne
	@JoinColumn
	@JsonView(View.Summary.class)
	@JsonIgnoreProperties({"group"})
	private Member owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "list", cascade = CascadeType.ALL)
	@JsonView(View.Summary.class)
	private Set<Item> items = new HashSet<Item>();

	public List(String name, Group group, Member member) {
		super();
		this.name = name;
		this.group = group;
		this.owner = member;
	}

	public List() {
		super();
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

	public void setOwner(Member member) {
		this.owner = member;
	}

	public Group getGroup() {
		return group;
	}

	public Set<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}


}
