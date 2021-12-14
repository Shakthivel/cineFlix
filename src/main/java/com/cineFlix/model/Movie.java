package com.cineFlix.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

import lombok.ToString;

@Entity
public class Movie implements Comparable<Movie> {

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName =null;
	@ToString.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Theatre> theatre;
	private Date releaseDate;
	private String movieSynopsis;
	private String censor;
	private String imageUrl;
	@OrderColumn
	private String genre;
	@OrderColumn
	private String language;

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


	public Set<Theatre> getTheatre() {
		return theatre;
	}


	public void setTheatre(Set<Theatre> theatre) {
		this.theatre = theatre;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getMovieSynopsis() {
		return movieSynopsis;
	}


	public void setMovieSynopsis(String movieSynopsis) {
		this.movieSynopsis = movieSynopsis;
	}


	public String getCensor() {
		return censor;
	}


	public void setCensor(String censor) {
		this.censor = censor;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName  + ", releaseDate="
				+ releaseDate + ", movieSynopsis=" + movieSynopsis + ", censor=" + censor + ", imageUrl=" + imageUrl
				+ ", genre=" + genre + ", language=" + language + "]";
	}





	public String getGenre() {
		return genre;
	}





	public void setGenre(String genre) {
		this.genre = genre;
	}





	public String getLanguage() {
		return language;
	}





	public void setLanguage(String language) {
		this.language = language;
	}





	@Override
	public int compareTo(Movie o) {
		return this.movieId - o.movieId;
	}

}
