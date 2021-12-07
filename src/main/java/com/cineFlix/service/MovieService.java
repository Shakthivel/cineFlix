package com.cineFlix.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Movie;

@Component
public interface MovieService {
	public Movie addMovie(Movie movie);

	public List<Movie> getAllMovies();
	public Movie getMovieById(int movieId);
}
