package com.cineFlix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.MovieDAO;
import com.cineFlix.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieDAO movieDAO;

	@Override
	public Movie addMovie(Movie movie) {
		return movieDAO.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieDAO.findAll();
	}

	@Override
	public Movie getMovieById(int movieId) {
		return movieDAO.getById(movieId);
	}

}
