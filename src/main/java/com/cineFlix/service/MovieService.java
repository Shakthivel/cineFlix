package com.cineFlix.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Movie;


public interface MovieService {
	public Movie addMovie(Movie movie);

	public List<Movie> getAllMovies();
	public Movie getMovieById(int movieId);
	public Optional<Movie> findMovieByNameAndDate(String name,Date date);
}
