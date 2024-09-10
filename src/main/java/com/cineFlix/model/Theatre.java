package com.cineFlix.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import lombok.ToString;

@Entity
public class Theatre implements Comparable<Theatre> {

	@Id
	private int theatreId;

	private String password;

	private String theatreName;

	private String theatreAddress;

	@ManyToMany(mappedBy = "theatre", fetch = FetchType.EAGER)
	@OrderBy
	private SortedSet<Movie> movies = new TreeSet<>();

	@OneToMany(mappedBy = "theatre", fetch = FetchType.EAGER)
	@OrderBy
	private SortedSet<Screen> screens = new TreeSet<>();

	public Theatre() {
		super();
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

	public SortedSet<Movie> getMovies() {
		return movies;
	}

	public void setMovies(SortedSet<Movie> movies) {
		this.movies = movies;
	}

	public SortedSet<Screen> getScreens() {
		return screens;
	}

	public void setScreens(SortedSet<Screen> screens) {
		this.screens = screens;
	}

	@Override
	public int compareTo(Theatre o) {
		return this.theatreId - o.theatreId;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", password=" + password + ", theatreName=" + theatreName
				+ ", theatreAddress=" + theatreAddress + ", movies=" + movies + "]";
	}
}
