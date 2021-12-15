package com.cineFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.AdminDAO;
import com.cineFlix.dao.MovieDAO;
import com.cineFlix.model.Admin;
import com.cineFlix.model.Movie;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	MovieDAO movieDAO;

	@Override
	public Admin login(int id, String password) {
		return adminDAO.findByIdAndPassword(id, password);
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieDAO.save(movie);
	}

}
