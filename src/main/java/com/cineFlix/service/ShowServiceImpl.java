package com.cineFlix.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public void getScreenIdById(String showId) {
		// TODO Auto-generated method stub
		System.out.println(showDAO.findScreenByShowId(showId));
	}

}
