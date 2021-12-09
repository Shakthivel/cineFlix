package com.cineFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cineFlix.dao.ShowDAO;
import com.cineFlix.model.ShowTable;

@Component
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	ShowDAO showDAO;

	@Override
	public ShowTable addShow(ShowTable show) {
		return showDAO.save(show);
	}

}
