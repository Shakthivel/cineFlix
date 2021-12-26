package com.cineFlix.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView getStart(ModelAndView view, HttpSession session) {

		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.setViewName("redirect:/admin/login");
		} else {
			view.setViewName("redirect:/admin/home");
		}
		return view;

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView view) {

		view.setViewName("admin-login");
		return view;

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView postLogin(@RequestParam("id") int id, @RequestParam("password") String password,
			ModelAndView view, HttpSession session) {

		Admin a = adminService.login(id, password);
		if (a == null) {
			view.setViewName("admin-login");
		} else {
			session.setAttribute("admin", a);
			view.setViewName("redirect:/admin/home");
		}
		return view;

	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView getHome(ModelAndView view, HttpSession session) {

		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			List<Movie> movies = movieService.getAllMovies();
			view.addObject("movies", movies);
			view.setViewName("admin-index");
		}
		return view;

	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.GET)
	public ModelAndView getAddMovie(ModelAndView view, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			Movie movie = new Movie();
			view.addObject(movie);
			view.setViewName("add-movies");
		}
		return view;
	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.POST)
	public ModelAndView postAddMovie(Movie movie, ModelAndView view, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			Movie m = movieService.addMovie(movie);
			if (m != null) {
				view.setViewName("redirect:/admin/home");
			} else {
				view.setViewName("add-movies");
			}
		}
		return view;
	}

	@RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.GET)
	public ModelAndView getEditMovie(@PathVariable int movieId, ModelAndView view, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			Movie movie = movieService.getMovieById(movieId);
			view.addObject("movie", movie);
			view.setViewName("add-movies");
		}
		return view;
	}

	@RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.POST)
	public ModelAndView postEditMovie(@PathVariable int movieId, Movie movie, ModelAndView view, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			Movie m = movieService.addMovie(movie);
			if (m != null) {
				view.setViewName("redirect:/admin/home");
			} else {
				view.setViewName("add-movies");
			}
		}
		return view;

	}

	@GetMapping("/import")
	public ModelAndView getFromExcel(HttpSession session, ModelAndView view) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			view.addObject("userRole", "admin");
			view.setViewName("error-screen");
		} else {
			view.setViewName("import-excel");
		}
		return view;
	}

	@PostMapping("/import")
	public String readFromExcel(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
		System.out.println("TEST");
		XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
			System.out.println("TEST");
			Movie movie = new Movie();
			XSSFRow row = worksheet.getRow(i);

			String movieName = row.getCell(0).getStringCellValue();
			Date releaseDate = convertJavaDateToSqlDate(row.getCell(1).getDateCellValue());
			String censor = row.getCell(2).getStringCellValue();
			String genre = row.getCell(3).getStringCellValue();
			String language = row.getCell(4).getStringCellValue();
			String movieSynopsis = row.getCell(5).getStringCellValue();
			String imageUrl = row.getCell(6).getStringCellValue();
			Optional<Movie> temp = movieService.findMovieByNameAndDate(movieName, releaseDate);
			System.out.println(movieName);
			if (temp.isEmpty()) {
				movie.setMovieName(movieName);
				movie.setReleaseDate(releaseDate);
				movie.setCensor(censor);
				movie.setGenre(genre);
				movie.setLanguage(language);
				movie.setMovieSynopsis(movieSynopsis);
				movie.setImageUrl(imageUrl);

				movieService.addMovie(movie);
			}
		}
		workbook.close();
		return "redirect:/admin/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}

	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
