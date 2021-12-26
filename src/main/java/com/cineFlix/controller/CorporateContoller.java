package com.cineFlix.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.Movie;
import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;
import com.cineFlix.model.Theatre;
import com.cineFlix.model.Timings;
import com.cineFlix.service.MovieService;
import com.cineFlix.service.ScreenService;
import com.cineFlix.service.ShowService;
import com.cineFlix.service.TheatreService;
import com.cineFlix.service.TimingService;

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
	TimingService timingService;

	@Autowired
	ShowService showService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(HttpSession session) {
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		if (theatre == null)
			return "redirect:/corporate/login";
		return "redirect:/corporte/home";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {

		return "corporate-login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

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
		model.addAttribute("theatre", theatre);
		if (theatre.getTheatreName() == null || theatre.getTheatreAddress() == null || theatre.getScreens().size() == 0)
			return "theatre-info";
		return "redirect:/corporate/home";
	}

	@RequestMapping(value = "/get-theatre-info", method = RequestMethod.POST)
	public String postTheatreInfo(Theatre theatre, @RequestParam("noOfScreens") int noOfScreens, HttpSession session) {
		theatre = theatreService.update(theatre);
		session.setAttribute("theatre", theatre);
		session.setAttribute("noOfScreens", noOfScreens);
		return "redirect:/corporate/get-screen-info";
	}

	@RequestMapping(value = "/get-screen-info", method = RequestMethod.GET)
	public String getScreenInfo(ModelMap model) {
		return "screen-info";
	}

	@RequestMapping(value = "/get-screen-info", method = RequestMethod.POST)
	public String postScreenInfo(HttpServletRequest request, ModelMap model, HttpSession session) {
		int noOfScreens = (int) session.getAttribute("noOfScreens");
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		SortedSet<Screen> screens = new TreeSet<Screen>();
		for (int i = 0; i < noOfScreens; i++) {
			String screenName = (String) (request.getParameterValues("screenName")[i]);
			String budgetRows = (String) (request.getParameterValues("budgetRows")[i]);
			String totalRows = (String) (request.getParameterValues("totalRows")[i]);
			String totalColumns = (String) (request.getParameterValues("totalColumns")[i]);
			Screen screen = new Screen();
			screen.setBudgetRows(Integer.parseInt(budgetRows));
			screen.setTotalRows(Integer.parseInt(totalRows));
			screen.setTotalColumns(Integer.parseInt(totalColumns));
			screen.setScreenName(screenName);
			screen.setTheatre(theatre);
			SortedSet<Timings> timings = new TreeSet<Timings>();
			for (int j = 1; j < 5; j++) {
				Timings timing = new Timings();
				timing.setScreen(screen);
				timing.setTiming(Time.valueOf(LocalTime.parse(request.getParameterValues("show" + j)[i].toString())));
				timingService.addTimings(timing);
				timings.add(timing);
			}

			screen.setTimings(timings);
			screenService.addScreen(screen);
			screens.add(screen);

		}
		theatre.setScreens(screens);
		theatre = theatreService.update(theatre);
		session.setAttribute("theatre", theatre);
		return "redirect:/corporate/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(ModelMap model, HttpSession session) {
		List<Movie> movies = movieService.getAllMovies();
		List<Movie> acquiredMovies = new ArrayList<Movie>();
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		if (theatre == null) {
			model.addAttribute("userRole", "corporate");
			return "error-screen";
		}
		
		for (Movie movie : movies) {
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
	public String postAddMovie(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		HttpSession session = request.getSession();
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		if (theatre == null) {
			model.addAttribute("userRole", "corporate");
			return "error-screen";
		}
		
		String movieId = (String) request.getParameter("movieId");
		return "redirect:/corporate/set-" + movieId + "-screen";

	}

	@GetMapping(value = "/set-{movieId}-screen")
	public String getSetScreen(@PathVariable int movieId, ModelMap model, HttpSession session) {
		Movie movie = movieService.getMovieById(movieId);
		System.out.println(movie);
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		if (theatre == null) {
			model.addAttribute("userRole", "corporate");
			return "error-screen";
		}
		model.addAttribute("movie", movie);
		model.addAttribute("screens", theatre.getScreens());
		for (Screen s : theatre.getScreens()) {
			System.out.println(s);
			for (Timings timing : s.getTimings()) {
				System.out.println(timing);
			}
		}
		return "acquire-movie";

	}

	@PostMapping(value = "/set-{movieId}-screen")
	@Transactional
	public String postSetScreen(@PathVariable int movieId, HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		Movie movie = movieService.getMovieById(movieId);
		String movieName = movie.getMovieName();

		HttpSession session = request.getSession();
		Theatre theatre = (Theatre) session.getAttribute("theatre");
		if (theatre == null) {
			model.addAttribute("userRole", "corporate");
			return "error-screen";
		}

		for (Screen screen : theatre.getScreens()) {
			SortedSet<ShowTable> shows = screen.getShows();
			SortedSet<ShowTable> removedShows = new TreeSet<ShowTable>();
			boolean upd = false;
			if (shows == null) {
				shows = new TreeSet<ShowTable>();
			}
			for (Timings timing : screen.getTimings()) {
				String selectedTiming = (request.getParameter(String.valueOf(timing.getId())));
				if (selectedTiming != null) {
					for (int i = 0; i < 7; i++) {
						ShowTable show = new ShowTable();
						show.setMovieName(movieName);
						show.setShowDate(Date.valueOf(LocalDate.now().plusDays(i)));
						show.setScreen(screen);
						show.setShowTime(timing.getTiming());
						show.setShowId();
						shows.add(show);
					}

					SortedSet<Theatre> theatreList = movie.getTheatre();
					SortedSet<Movie> moviesList = theatre.getMovies();

					moviesList.add(movie);
					theatre.setMovies(moviesList);
					theatreService.update(theatre);

					if (theatreList == null) {
						theatreList = new TreeSet<Theatre>();
					}
					theatreList.add(theatre);
					movie.setTheatre(theatreList);
					movieService.addMovie(movie);

				} else {
					if (screen.getShows() != null) {
						for (ShowTable show : screen.getShows()) {
							if (show.getShowTime().equals(timing.getTiming())) {
								if (show.getMovieName() != null) {
									if (show.getMovieName().equals(movie.getMovieName())) {
										upd = true;
										removedShows.add(show);
										showService.deleteShow(show);
									}
								}
							}
						}
					}
				}

			}
			if (upd) {
				SortedSet<ShowTable> remainingShows = new TreeSet<ShowTable>();
				remainingShows.addAll(shows);
				remainingShows.removeAll(removedShows);
				screen.setShows(remainingShows);
			} else {
				screen.setShows(shows);
			}
			screenService.addScreen(screen);

		}
		if (movieNotExistsInTheatre(theatre, movie)) {
			SortedSet<Theatre> theatreList = movie.getTheatre();
			SortedSet<Movie> moviesList = theatre.getMovies();

			moviesList.remove(movie);
			theatre.setMovies(moviesList);
			theatreService.update(theatre);

			if (theatreList == null) {
				theatreList = new TreeSet<Theatre>();
			}
			theatreList.remove(theatre);
			movie.setTheatre(theatreList);
			movieService.addMovie(movie);
		}
		return "redirect:/corporate/home";

	}

	public boolean movieNotExistsInTheatre(Theatre theatre, Movie movie) {
		
		for (Screen screen : theatre.getScreens()) {
			for (ShowTable show : screen.getShows()) {
				if (show.getMovieName() != null) {
					if (show.getMovieName().equals(movie.getMovieName())) {
						return false;
					}
				}

			}
		}
		return true;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/corporate/login";
	}

}
