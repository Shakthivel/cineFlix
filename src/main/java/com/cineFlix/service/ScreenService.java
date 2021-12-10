package com.cineFlix.service;

import org.springframework.stereotype.Component;

import com.cineFlix.model.Screen;

@Component
public interface ScreenService {

	public Screen addScreen(Screen screen);
	
}
