package com.cineFlix.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cineFlix.model.ShowTable;

public interface ShowService  {

	public ShowTable addShow(ShowTable show);
	public ShowTable getShowById(String showId);
	public void deleteShow(ShowTable show);
}
