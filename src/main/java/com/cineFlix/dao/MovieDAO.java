package com.cineFlix.dao;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.Movie;

public interface MovieDAO extends JpaRepository<Movie,Integer> {

	Optional<Movie> findByMovieNameAndReleaseDate(String movieName,Date releaseDate);

}
