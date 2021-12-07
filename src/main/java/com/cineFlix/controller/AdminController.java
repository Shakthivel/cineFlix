package com.cineFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.Admin;
import com.cineFlix.model.Movie;
import com.cineFlix.service.AdminService;
import com.cineFlix.service.MovieService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	MovieService movieService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLogin() {
		
		return "admin-login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String postLogin(@RequestParam("id") int id, @RequestParam("password") String password) {
		// TODO: Authenicate
		Admin a = adminService.login(id, password);
		System.out.println(a);
		if (a == null) {
			return "admin-login";
		}

		return "redirect:/admin/home";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		List<Movie> movies = movieService.getAllMovies();
		System.out.println(movies);
		model.addAttribute("movies",movies);
		return "admin-index";
	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.GET)
	public String getAddMovie(ModelMap model) {
		Movie movie = new Movie();
		model.addAttribute(movie);
		return "add-movies";
	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.POST)
	public String postAddMovie(Movie movie, ModelMap model) {
		Movie m = movieService.addMovie(movie);
		System.out.println(m);
		if (m != null) {
			return "redirect:/admin/home";
		}
		return "add-movies";
	}
	
    @RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.GET)
    public String getEditMovie(@PathVariable int movieId, ModelMap model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "add-movies";
    }
    @RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.POST)
    public String postEditMovie(@PathVariable int movieId,Movie movie, ModelMap model) {
    	Movie m = movieService.addMovie(movie);
		System.out.println(m);
		if (m != null) {
			return "redirect:/admin/home";
		}
        return "add-movies";
    }
}
