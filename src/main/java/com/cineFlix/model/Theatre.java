package com.cineFlix.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Theatre implements Comparable<Theatre> {

	@Id
	private int theatreId;
	private String password;
	private String theatreName;
	private String theatreAddress;
	@ManyToMany(mappedBy = "theatre")
	private List<Movie> movies;
	@OneToMany(mappedBy="theatre")
	private List<Screen> screens;

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", password=" + password + ", theatreName=" + theatreName
				+ ", theatreAddress=" + theatreAddress + ", movies=" + movies + ", screens=" + screens + "]";
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	@Override
	public int compareTo(Theatre o) {
		return this.theatreId-o.theatreId;
	}
	
	

}
