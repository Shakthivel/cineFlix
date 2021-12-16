package com.cineFlix.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cineFlix.model.Movie;
import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;
import com.cineFlix.model.Theatre;
import com.cineFlix.model.Ticket;
import com.cineFlix.model.User;
import com.cineFlix.service.MovieService;
import com.cineFlix.service.PdfService;
import com.cineFlix.service.ScreenService;
import com.cineFlix.service.ShowService;
import com.cineFlix.service.EmailService;
import com.cineFlix.service.PdfService;
import com.cineFlix.service.TheatreService;
import com.cineFlix.service.TicketService;
import com.itextpdf.html2pdf.HtmlConverter;

@Controller
@RequestMapping("/")
@ComponentScan("com")
public class AppController {

	@Autowired
	MovieService movieService;

	@Autowired
	ScreenService screenService;

	@Autowired
	ShowService showService;

	@Autowired
	TicketService ticketService;
	
	@Autowired
	PdfService pdfService;
	
	@Autowired
	EmailService emailService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String landingPage(ModelMap model,HttpSession session) {
		// TODO: Implement session management and redirect to user home or corp home
		User user = (User) session.getAttribute("user");
		if(user!=null)
		{
			List<Movie> upcomingMovies = new ArrayList<Movie>();
			List<Movie> nowShowing = new ArrayList<Movie>();
			for (Movie movie : movieService.getAllMovies()) {
				if (movie.getTheatre().size() > 0) {
					nowShowing.add(movie);
				} else {
					upcomingMovies.add(movie);
				}
			}
			model.addAttribute("nowShowing", nowShowing);
			model.addAttribute("upcomingMovies", upcomingMovies);
			model.addAttribute("movies", movieService.getAllMovies());
			return "index";
		}
		return "redirect:/user/login";
	}

	@GetMapping("/movie-{movieId}-availability")
	public String getMovieAvailability(@PathVariable int movieId, ModelMap model, HttpSession session) {
		Movie movie = movieService.getMovieById(movieId);
		model.addAttribute("movie", movie);
		session.setAttribute("movie", movie);

		return "movie-availability";
	}

	@GetMapping("/screen-{screenId}-show-{showId}-date-{date}-seats")
	public String getMovieSeats(@PathVariable int screenId, ModelMap model, HttpSession session) {
		Screen screen = screenService.getScreenById(screenId);
		model.addAttribute("screen", screen);
		return "seat-screen";
	}

	@PostMapping("/screen-{screenId}-show-{showId}-date-{date}-seats")
	public String postMovieSeats(@PathVariable int screenId, @PathVariable int showId, @PathVariable String date,
			HttpServletRequest request, HttpServletResponse response) {

		Screen screen = screenService.getScreenById(screenId);
		ShowTable show = showService.getShowById(showId);
		String seats = request.getParameter("formValue");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null)
		{
			
		}
		Movie movie = (Movie) session.getAttribute("movie");
		Theatre theatre = null;
		for (Theatre t : movie.getTheatre()) {
			for (Screen s : t.getScreens()) {
				if (s.getId() == screen.getId()) {
					theatre = t;
					break;
				}
			}
		}
		Ticket ticket = new Ticket();
		ticket.setMovieName(movie.getMovieName());
		ticket.setNoOfSeats(seats.split(",").length);
		ticket.setScreenName(screen.getScreenName());
		ticket.setSeatNumbers(seats);
		System.out.println(date);
		ticket.setShowDate(Date.valueOf(date.replace("_", "-")));
		ticket.setShowTiming(show.getShowTime());
		ticket.setTheatreName(theatre.getTheatreName());
		ticket.setUser(user);

		session.setAttribute("ticket", ticket);

		return "redirect:/confirm-ticket";
	}

	@GetMapping("/confirm-ticket")
	public String getConfirmTicket(HttpSession session, ModelMap model) {
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		System.out.println(ticket);
		model.addAttribute("ticket", ticket);
		return "booking-screen";
	}

	@PostMapping("/confirm-ticket")
	public String postConfirmTicket(HttpSession session, ModelMap model) {
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		System.out.println(ticket);
		ticketService.addTicket(ticket);
		try {
			pdfService.generatePdf(ticket);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = (User) session.getAttribute("user");
		emailService.sendEmail(ticket.getTicketId(),user);
		return "redirect:/";
	}
}
