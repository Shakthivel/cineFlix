package com.cineFlix.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

@Entity
public class Movie implements Comparable<Movie> {

	@Id
	private int movieId;
	private String movieName;
	@ManyToMany()
	private List<Theatre> theatre;
	private Date releaseDate;
	private String movieSynopsis;
	private String censor;
	private String imageUrl;
	@OrderColumn
	private String[] genre;
	@OrderColumn
	private String[] languages;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", theatre=" + theatre + ", releaseDate="
				+ releaseDate + ", movieSynopsis=" + movieSynopsis + ", censor=" + censor + ", imageUrl=" + imageUrl
				+ ", genre=" + Arrays.toString(genre) + ", languages=" + Arrays.toString(languages) + "]";
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


	public String[] getGenre() {
		return genre;
	}


	public void setGenre(String[] genre) {
		this.genre = genre;
	}


	public String[] getLanguages() {
		return languages;
	}


	public void setLanguages(String[] languages) {
		this.languages = languages;
	}


	@Override
	public int compareTo(Movie o) {
		return this.movieId - o.movieId;
	}

}
