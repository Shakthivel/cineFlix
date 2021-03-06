package com.cineFlix.model;

import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String password;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String number;
	private String address;
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	@OrderBy
	private SortedSet<Ticket> ticket;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String name, String password, String email, String number, String address,
			SortedSet<Ticket> ticket) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.ticket = ticket;
	}

	public SortedSet<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(SortedSet<Ticket> ticket) {
		this.ticket = ticket;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + ", number="
				+ number + ", address=" + address + "]";
	}

}
