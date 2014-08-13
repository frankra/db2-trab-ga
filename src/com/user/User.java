package com.user;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group.member.Member;

@Entity
@Table(name="USER")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(nullable=false, unique=true)
	private String login;
	@Column(nullable=false)
	private String password;
	@Column
	private String email;
	@Column(nullable=false)
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int age;
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private String address;
	
	/**/
	@Column 
	private Timestamp lastChangedOn;
	@Column
	private Timestamp createdOn;
	/**/
	
	public User(){
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	};
	
	public User(String firstName, String lastName, String email,String login, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.lastChangedOn = this.createdOn;
	};
	
	public User(String firstName,String login, String password){
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getID(){
		return this.ID;
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
	
	
}
