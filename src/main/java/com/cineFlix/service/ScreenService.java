package com.cineFlix.service;

import java.sql.Date;
import java.sql.Time;
import java.util.SortedSet;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;


public interface ScreenService {

	public Screen addScreen(Screen screen);
	public Screen getScreenById(int id);
	public void update(int id, SortedSet<ShowTable> shows);
	
}
