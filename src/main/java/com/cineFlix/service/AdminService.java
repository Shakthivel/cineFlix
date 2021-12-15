package com.cineFlix.service;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Admin;
import com.cineFlix.model.Movie;


public interface AdminService {
	public Admin login(int id, String password);
	public Movie addMovie(Movie movie);
}
