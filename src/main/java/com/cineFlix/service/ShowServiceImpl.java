package com.cineFlix.service;

import java.sql.Date;
import java.sql.Time;

import javax.transaction.Transactional;

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
	@Transactional
	public ShowTable addShow(ShowTable show) {
		return showDAO.save(show);
	}

	@Override
	public ShowTable getShowById(String id) {
		return showDAO.getById(id);
	}

	@Override
	public void deleteShow(ShowTable show) {
		showDAO.delete(show);
	}

}
