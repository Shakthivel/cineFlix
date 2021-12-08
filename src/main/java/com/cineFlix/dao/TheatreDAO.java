package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.Theatre;

public interface TheatreDAO extends JpaRepository<Theatre, Integer> {
	public Theatre findByTheatreIdAndPassword(int movieId, String password);
}
