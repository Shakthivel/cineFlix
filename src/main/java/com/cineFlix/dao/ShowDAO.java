package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.ShowTable;

public interface ShowDAO extends JpaRepository<ShowTable, String>{

	public String findMovieNameByShowId(int id);
}
