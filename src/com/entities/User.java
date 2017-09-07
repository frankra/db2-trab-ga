package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String password;
	@Column
	private String email;
	@Column(nullable = false)
	private String firstName;
	@Column
	private String lastName;

	
	public User() {
		super();
	};

	public User(String firstName, String lastName, String email, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
	};

	public User(String firstName, String login, String password) {
		super();
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	};

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
