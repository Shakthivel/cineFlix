package com.cineFlix.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.ShowDAO;
import com.cineFlix.model.ShowTable;

@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	ShowDAO showDAO;

	@Override
	public ShowTable addShow(ShowTable show) {
		return showDAO.save(show);
	}

	@Override
	public ShowTable getShowById(int id) {
		return showDAO.getById(id);
	}

}
