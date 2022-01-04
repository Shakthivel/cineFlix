package com.cineFlix.controller;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.cineFlix.service.ScreenService;
import com.cineFlix.service.ShowService;
import com.cineFlix.service.EmailService;
import com.cineFlix.service.TheatreService;
import com.cineFlix.service.TicketService;
import com.cineFlix.service.UserService;
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
	UserService userService;

	@Autowired
	ScreenService screenService;

	@Autowired
	ShowService showService;

	@Autowired
	TicketService ticketService;

	@Autowired
	TheatreService theatreService;

	@Autowired
	PdfService pdfService;

	@Autowired
	EmailService emailService;

	@Autowired
	PaypalService paypalService;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/")
	public String getWelcome(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return "redirect:/welcome";
		}
		return "redirect:/user/login";
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public ModelAndView landingPage(HttpSession session, ModelAndView view) {
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
			view.addObject("nowShowing", nowShowing);
			view.addObject("upcomingMovies", upcomingMovies);
			view.addObject("movies", movieService.getAllMovies());
			view.addObject("user", user);
			view.setViewName("index");
		} else {
			view.setViewName("redirect:/user/login");
		}
		return view;
	}

	@GetMapping("/history")
	public ModelAndView getTicketHistory(HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {

			view.addObject("tickets", user.getTicket());
			view.setViewName("history");
		}
		return view;
	}

	@GetMapping("/movie-{movieId}-availability")
	public ModelAndView getMovieAvailability(@PathVariable int movieId, ModelAndView view, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			Movie movie = movieService.getMovieById(movieId);
			session.setAttribute("movie", movie);

			view.addObject("movie", movie);
			view.setViewName("movie-availability");
		}
		return view;
	}

	@GetMapping("/seat-{showId}-show")
	public ModelAndView getMovieSeats(@PathVariable String showId, ModelAndView view, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			int screenId = Integer.parseInt(showId.split("_")[0]);
			Screen screen = screenService.getScreenById(screenId);
			view.addObject("screen", screen);

			ShowTable show = showService.getShowById(showId);
			view.addObject("show", show);
			view.setViewName("seat-screen");
		}

		return view;
	}

	@PostMapping("/seat-{showId}-show")
	public ModelAndView postMovieSeats(@PathVariable String showId, HttpServletRequest request, ModelAndView view,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			// get screenId and date from showId Pattern
			int screenId = Integer.parseInt(showId.split("_")[0]);
			String date = showId.split("_")[1];

			Screen screen = screenService.getScreenById(screenId);
			ShowTable show = showService.getShowById(showId);
			String seats = request.getParameter("formValue");

			String alreadyBookedSeats = show.getSeats();
			if (alreadyBookedSeats == null) {
				alreadyBookedSeats = "";
			}
			alreadyBookedSeats += seats;
			// update seats
			show.setSeats(alreadyBookedSeats);
			// add show with updated seat to session
			session.setAttribute("show", show);

			// TICKET GENERATION
			// Get Movie
			Movie movie = (Movie) session.getAttribute("movie");
			// Get Theatre
			Theatre theatre = show.getScreen().getTheatre();
			// Generate ticket
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
			// Add ticket to session
			session.setAttribute("ticket", ticket);

			view.setViewName("redirect:/confirm-ticket");
		}

		return view;
	}

	@GetMapping("/confirm-ticket")
	public ModelAndView getConfirmTicket(HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			view.setViewName("booking-screen");
		}
		return view;
	}

	@PostMapping("/confirm-ticket")
	public ModelAndView postConfirmTicket(HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			Ticket ticket = (Ticket) session.getAttribute("ticket");
			view.setViewName("redirect:/ordersuccess");
			try {

				Order order = new Order(ticket.getPrice(), "USD", "PayPal", "sale", "Payment to cineFlix");

				Payment payment = paypalService.createPayment((double) order.getPrice(), order.getCurrency(),
						order.getMethod(), order.getIntent(), order.getDescription(),
						"http://localhost:8080/" + CANCEL_URL, "http://localhost:8080/" + SUCCESS_URL);
				for (Links link : payment.getLinks()) {
					System.out.println("Link: " + link.getRel() + " : " + link.getHref());
					if (link.getRel().equals("approval_url")) {

						return new ModelAndView("redirect:" + link.getHref());
					}
				}

			} catch (PayPalRESTException e) {

				e.printStackTrace();
			}
		}

		return view;
	}

	@GetMapping("/get-ticket")
	public ModelAndView getTicket(HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			ShowTable show = (ShowTable) session.getAttribute("show");
			Ticket ticket = (Ticket) session.getAttribute("ticket");
			SortedSet<Ticket> tickets = user.getTicket();
			if (tickets == null) {
				tickets = new TreeSet<Ticket>();
			}
			tickets.add(ticket);
			user.setTicket(tickets);
			userService.register(user);
			showService.addShow(show);
			ticketService.addTicket(ticket);
			try {
				pdfService.generatePdf(ticket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			emailService.sendEmail(ticket.getTicketId(), user);
			view.setViewName("redirect:/booking-success");
		}
		return view;
	}

	@GetMapping("/booking-success")
	public ModelAndView getBookingSuccess(HttpSession session, ModelAndView view) {
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		if (ticket == null) {
			view.addObject("userRole", "user");
			view.setViewName("error-screen");
		} else {
			view.setViewName("payment-over");
		}
		return view;
	}

	@PostMapping("/booking-success")
	@ResponseBody
	public void postBookingSuccess(HttpSession session, HttpServletResponse response) {

		Ticket ticket = (Ticket) session.getAttribute("ticket");
		String projectDirectory = Paths.get("").toAbsolutePath().toString();
		String pdfDirectory = projectDirectory + "\\src\\main\\resources\\static\\pdf\\";
		String fileName = pdfDirectory + "Ticket.pdf";

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=ticket.pdf");
		response.setHeader("Content-Transfer-Encoding", "binary");
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(fileName);
			int len;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) > 0) {
				bos.write(buf, 0, len);
			}
			bos.close();
			fis.close();
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
