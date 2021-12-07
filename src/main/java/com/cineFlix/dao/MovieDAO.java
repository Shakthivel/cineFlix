package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.Movie;

public interface MovieDAO extends JpaRepository<Movie,Integer> {

}
