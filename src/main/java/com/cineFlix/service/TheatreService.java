package com.cineFlix.service;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Theatre;

@Component
public interface TheatreService {
	public Theatre login(int id,String password);
}
