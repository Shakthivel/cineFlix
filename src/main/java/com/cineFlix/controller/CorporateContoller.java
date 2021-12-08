package com.cineFlix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.Movie;
import com.cineFlix.model.Theatre;
import com.cineFlix.service.MovieService;
import com.cineFlix.service.TheatreService;

@Controller
@RequestMapping("/corporate")
public class CorporateContoller {
	
	@Autowired
	TheatreService theatreService;
	
	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String getLogin()
	{
		return "corporate-login";
	}
	
	@RequestMapping(value = "/login" , method=RequestMethod.POST)
	public String postLogin(@RequestParam("id") int id, @RequestParam("password") String password, ModelMap model)
	{
		Theatre theatre = theatreService.login(id, password);
		System.out.println(theatre);
		
		if(theatre!=null)
		{
			model.addAttribute("theatre", theatre);
		return "redirect:/corporate/home";
		}
		return "corporate-login";
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		List<Movie> movies = movieService.getAllMovies();
		List<Movie> acquiredMovies = new ArrayList<Movie>();
		Theatre theatre = (Theatre) model.getAttribute("theatre");
		for(Movie movie:movies)
		{
			if (movie.getTheatre().contains(theatre))
			{
				acquiredMovies.add(movie);
				movies.remove(movie);
			}
		}
		System.out.println(movies);
		System.out.println(acquiredMovies);
		model.addAttribute("movies",movies);
		model.addAttribute("acquiredMovies",acquiredMovies);
		return "corporate-index";
	}
	
}
