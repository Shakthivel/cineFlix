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
import org.springframework.web.servlet.ModelAndView;

import com.cineFlix.model.Movie;
import com.cineFlix.model.Order;
import com.cineFlix.model.Screen;
import com.cineFlix.model.ShowTable;
import com.cineFlix.model.Theatre;
import com.cineFlix.model.Ticket;
import com.cineFlix.model.User;
import com.cineFlix.service.MovieService;
import com.cineFlix.service.PaypalService;
import com.cineFlix.service.PdfService;
import com.cineFlix.service.SMSService;
import com.cineFlix.service.ScreenService;
import com.cineFlix.service.ShowService;
import com.cineFlix.service.EmailService;
import com.cineFlix.service.PdfService;
import com.cineFlix.service.TheatreService;
import com.cineFlix.service.TicketService;
import com.itextpdf.html2pdf.HtmlConverter;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

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
	
	@Autowired
	PaypalService paypalService;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String landingPage(ModelMap model, HttpSession session) {
		// TODO: Implement session management and redirect to user home or corp home
		User user = (User) session.getAttribute("user");
		if (user != null) { 
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

	@GetMapping("/seat-{showId}-show")
	public String getMovieSeats(@PathVariable String showId, ModelMap model, HttpSession session) {
		int screenId = Integer.parseInt(showId.split("_")[0]);
		Screen screen = screenService.getScreenById(screenId);
		model.addAttribute("screen", screen);
		ShowTable show = showService.getShowById(showId);
		System.out.println(show);
		return "seat-screen";
	}

	@PostMapping("/seat-{showId}-show")
	public String postMovieSeats(@PathVariable String showId,
			HttpServletRequest request, HttpServletResponse response) {

		int screenId = Integer.parseInt(showId.split("_")[0]);
		String date = showId.split("_")[1];
		Screen screen = screenService.getScreenById(screenId);
		ShowTable show = showService.getShowById(showId);
		System.out.println(show);
		String seats = request.getParameter("formValue");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {

		}
		Movie movie = (Movie) session.getAttribute("movie");
		Theatre theatre = null;
		for (Theatre t : movie.getTheatre()) {
			for (Screen sc : t.getScreens()) {
				for(ShowTable sh: sc.getShows() )
				{
					if (sh.getShowId().equals(show.getShowId()) ) {
						theatre = t;
						break;
					}
				}
				
			}
		}
		int n = seats.split(",").length;
		Ticket ticket = new Ticket();
		ticket.setMovieName(movie.getMovieName());
		ticket.setNoOfSeats(n);
		ticket.setScreenName(screen.getScreenName());
		ticket.setSeatNumbers(seats);
		ticket.setShowDate(Date.valueOf(date));
		ticket.setShowTiming(show.getShowTime());
		ticket.setTheatreName(theatre.getTheatreName());
		ticket.setUser(user);
		ticket.setPrice(180 * n + 10 * n + 30 * n);

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
	public ModelAndView postConfirmTicket(HttpSession session, ModelAndView model) {
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		 model.setViewName("redirect:/ordersuccess");
		try {

			Order order = new Order(ticket.getPrice(), "USD", "PayPal", "sale", "Payment to cineFlix");

			Payment payment = paypalService.createPayment((double) order.getPrice(), order.getCurrency(),
					order.getMethod(), order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for (Links link : payment.getLinks()) {
				System.out.println("Link: " + link.getRel() + " : " + link.getHref());
				if (link.getRel().equals("approval_url")) {
					try {
						pdfService.generatePdf(ticket);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return new ModelAndView("redirect:" + link.getHref());
				}
			}

		} catch (PayPalRESTException e) {

			e.printStackTrace();
		}
		return model;
	}

	@GetMapping("/get-ticket")
	public String getTicket(HttpSession session, ModelMap model) {
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		User user = (User) session.getAttribute("user");
		emailService.sendEmail(ticket.getTicketId(), user);
		ticketService.addTicket(ticket);
		return "redirect:/";
	}
}
