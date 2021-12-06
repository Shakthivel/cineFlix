package com.cineFlix.controller;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@ComponentScan("com") 
public class AppController {
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String landingPage(ModelMap model) {
		//TODO: Implement session management and redirect to user home or corp home
        return "index";
    }

}
