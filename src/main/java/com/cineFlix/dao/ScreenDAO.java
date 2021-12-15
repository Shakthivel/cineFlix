package com.cineFlix.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineFlix.model.Screen;

public interface ScreenDAO extends JpaRepository<Screen, Integer> {
	
	

}
