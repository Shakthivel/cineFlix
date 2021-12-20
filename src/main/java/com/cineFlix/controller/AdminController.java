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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String getStart(HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			return "redirect:/admin/login";
		}
		return "redirect:/admin/home";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLogin() {
		return "admin-login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String postLogin(@RequestParam("id") int id, @RequestParam("password") String password,
			HttpSession session) {
		// TODO: Authenicate
		Admin a = adminService.login(id, password);
		session.setAttribute("admin", a);
		if (a == null) {
			return "admin-login";
		}

		return "redirect:/admin/home";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String getHome(ModelMap model, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		return "admin-index";
	}

	@PostMapping(value = "/home")
	public void postHome(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
		System.out.println("Home post method");

	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.GET)
	public String getAddMovie(ModelMap model, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		Movie movie = new Movie();
		model.addAttribute(movie);
		return "add-movies";
	}

	@RequestMapping(value = { "/add-movie" }, method = RequestMethod.POST)
	public String postAddMovie(Movie movie, ModelMap model, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		Movie m = movieService.addMovie(movie);
		if (m != null) {
			return "redirect:/admin/home";
		}
		return "add-movies";
	}

	@RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.GET)
	public String getEditMovie(@PathVariable int movieId, ModelMap model, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		Movie movie = movieService.getMovieById(movieId);
		model.addAttribute("movie", movie);
		return "add-movies";
	}

	@RequestMapping(value = { "/edit-{movieId}-movie" }, method = RequestMethod.POST)
	public String postEditMovie(@PathVariable int movieId, Movie movie, ModelMap model, HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		Movie m = movieService.addMovie(movie);
		if (m != null) {
			return "redirect:/admin/home";
		}
		return "add-movies";
	}
	
	@GetMapping("/import")
	public String getFromExcel(HttpSession session, ModelMap model)
	{
		Admin a = (Admin) session.getAttribute("admin");
		if (a == null) {
			model.addAttribute("userRole", "admin");
			return "error-screen";
		}
		return "import-excel";
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
