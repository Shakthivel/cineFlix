package com.cineFlix.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Screen;


public interface ScreenService {

	public Screen addScreen(Screen screen);
	public Screen getScreenById(int id);
	
}
