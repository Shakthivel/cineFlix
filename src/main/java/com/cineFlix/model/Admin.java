package com.cineFlix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin implements Comparable<Admin> {
	@Id
	private int id;
	private String password;

	
	public Admin() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(Admin o) {
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", password=" + password + "]";
	}

}
