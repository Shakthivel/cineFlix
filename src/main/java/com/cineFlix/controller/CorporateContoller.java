package com.cineFlix.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.Movie;
import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;
import com.cineFlix.model.Theatre;
import com.cineFlix.service.MovieService;
import com.cineFlix.service.ScreenService;
import com.cineFlix.service.ShowService;
import com.cineFlix.service.TheatreService;

@Controller
@RequestMapping("/corporate")
public class CorporateContoller {

	@Autowired
	TheatreService theatreService;

	@Autowired
	MovieService movieService;
	
	@Autowired
	ScreenService screenService;
	
	@Autowired
	ShowService showService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "corporate-login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@RequestParam("id") int id, @RequestParam("password") String password, ModelMap model,
			HttpSession session) {
		Theatre theatre = theatreService.login(id, password);
		session.setAttribute("theatre", theatre);
		if (theatre != null) {
			model.addAttribute("theatre", theatre);
			return "redirect:/corporate/get-theatre-info";
		}
		return "corporate-login";
	}

	@RequestMapping(value = "/get-theatre-info", method = RequestMethod.GET)
	public String getTheatreInfo(ModelMap model, HttpSession session) {
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		System.out.println(theatre);
		model.addAttribute("theatre", theatre);
		if (theatre.getTheatreName() == null || theatre.getTheatreAddress() == null || theatre.getScreens().size() == 0)
			return "theatre-info";
		return "redirect:/corporate/home";
	}

	@RequestMapping(value = "/get-theatre-info", method = RequestMethod.POST)
	public String postTheatreInfo(Theatre theatre, @RequestParam("noOfScreens") int noOfScreens, HttpSession session) {
		System.out.println(theatre);
		theatre = theatreService.update(theatre);
		System.out.println(theatre);
		session.setAttribute("noOfScreens", noOfScreens);
		return "redirect:/corporate/get-screen-info";
	}

	@RequestMapping(value = "/get-screen-info", method = RequestMethod.GET)
	public String getScreenInfo(ModelMap model, HttpSession session) {
		int noOfScreens = (int) session.getAttribute("noOfScreens");
		return "screen-info";
	}

	@RequestMapping(value="/get-screen-info",method=RequestMethod.POST)
	public String postScreenInfo(HttpServletRequest request,ModelMap model,HttpSession session)
	{
		int noOfScreens = (int) session.getAttribute("noOfScreens");
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		for(int i=0;i<noOfScreens;i++)
		{
			String screenName = (String)(request.getParameterValues("screenName")[i]);
			String budgetRows = (String)(request.getParameterValues("budgetRows")[i]);
			String totalRows = (String)(request.getParameterValues("totalRows")[i]);
			String totalColumns = (String)(request.getParameterValues("totalColumns")[i]);
			
			Screen screen = new Screen();
			screen.setBudgetRows(Integer.parseInt(budgetRows));
			screen.setTotalRows(Integer.parseInt(totalRows));
			screen.setTotalColumns(Integer.parseInt(totalColumns));
			screen.setScreenName(screenName);
			screen.setTheatre(theatre);
			Set<ShowTable> shows = new HashSet<ShowTable>();
			
			for(int j=1;j<5;j++)
			{			
			ShowTable show = new ShowTable();
			show.setScreen(screen);
			show.setShowTime(Time.valueOf( LocalTime.parse( request.getParameterValues("show"+j)[i].toString() ) ));
			showService.addShow(show);
			shows.add(show);
			}

			screen.setShows(shows);
			screenService.addScreen(screen);
			
		}
		return "screen-info";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(ModelMap model, HttpSession session) {
		List<Movie> movies = movieService.getAllMovies();
		List<Movie> acquiredMovies = new ArrayList<Movie>();
		Theatre theatre = (Theatre) session.getAttribute("theatre");

		for (Movie movie : movies) {
			System.out.println(movie.getTheatre());
			for (Theatre existingTheatre : movie.getTheatre()) {

				if (theatre.getTheatreId() == existingTheatre.getTheatreId()) {
					acquiredMovies.add(movie);
				}
			}
		}
		movies.removeAll(acquiredMovies);
		model.addAttribute("movies", movies);
		model.addAttribute("acquiredMovies", acquiredMovies);
		return "corporate-index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String postAddMovie(@RequestParam("movieId") String movieId, HttpSession session) {
		System.out.println(movieId);
		Movie movie = movieService.getMovieById(Integer.parseInt(movieId));
		Set<Theatre> theatreList = movie.getTheatre();

		Theatre theatre = (Theatre) session.getAttribute("theatre");
		Set<Movie> moviesList = theatre.getMovies();
		moviesList.add(movie);
		theatre.setMovies(moviesList);
		theatreService.update(theatre);

		if (theatreList == null) {
			theatreList = new HashSet<Theatre>();
		}
		theatreList.add(theatre);
		movie.setTheatre(theatreList);
		movieService.addMovie(movie);

		return "redirect:/corporate/home";
	}

}
