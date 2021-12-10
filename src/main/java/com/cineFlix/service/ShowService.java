package com.cineFlix.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cineFlix.model.ShowTable;

@Component
public interface ShowService  {

	public ShowTable addShow(ShowTable show);
	
}
