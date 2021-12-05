package com.cineFlix.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie implements Comparable<Movie> {

	@Id
	private int movieId;
	private String movieName;
	@ManyToMany()
	private List<Theatre> theatre;
	private Date releaseDate;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<Theatre> getTheatre() {
		return theatre;
	}

	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", theatre=" + theatre + ", releaseDate="
				+ releaseDate + "]";
	}

	@Override
	public int compareTo(Movie o) {
		return this.movieId - o.movieId;
	}

}
