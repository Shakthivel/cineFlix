package com.cineFlix.service;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cineFlix.dao.ScreenDAO;
import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;

@Service
public class ScreenServiceImpl implements ScreenService{
	
	@Autowired
	ScreenDAO screenDAO;

	@Override
	public Screen addScreen(Screen screen) {
		return screenDAO.save(screen);
	}

	@Override
	public Screen getScreenById(int id) {
		return screenDAO.getById(id);
	}

	@Override
	public void update(int id, SortedSet<ShowTable> shows) {
		Screen screen = screenDAO.getById(id);
		screen.setShows(shows);
		screenDAO.save(screen);	
	}
	
	

	
}
