package com.cineFlix.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Theatre;


public interface TheatreService {
	public Theatre login(int id,String password);
	public Theatre update(Theatre theatre);
	public Optional<Theatre> findTheatreById(int id);
}
