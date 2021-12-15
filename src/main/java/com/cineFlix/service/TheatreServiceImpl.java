package com.cineFlix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cineFlix.dao.TheatreDAO;
import com.cineFlix.model.Theatre;

@Service
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	TheatreDAO theatreDAO;

	@Override
	public Theatre login(int id, String password) {
		return theatreDAO.findByTheatreIdAndPassword(id, password);
	}

	public Theatre update(Theatre theatre) {
		return theatreDAO.save(theatre);
	}

	@Override
	public Optional<Theatre> findTheatreById(int id) {
		return  theatreDAO.findById(id);
	}
}
