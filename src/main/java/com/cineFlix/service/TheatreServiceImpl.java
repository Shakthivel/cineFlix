package com.cineFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cineFlix.dao.TheatreDAO;
import com.cineFlix.model.Theatre;

@Component
public class TheatreServiceImpl implements TheatreService{
	
	@Autowired
	TheatreDAO theatreDAO;

	@Override
	public Theatre login(int id, String password) {
		return theatreDAO.findByTheatreIdAndPassword(id, password);
	}

	public Theatre update(Theatre theatre)
	{
		return theatreDAO.save(theatre);
	}
}
