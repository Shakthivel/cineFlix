package com.cineFlix.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.User;
import com.cineFlix.service.SMSService;
import com.cineFlix.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	SMSService smsService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLogin() {
		return "user-login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String postLogin(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		// TODO: User authentication
		User u = userService.login(name, password);
		session.setAttribute("user", u);
		System.out.println(u);
		if (u != null) {
			return "redirect:/";
		}
		return "redirect:/user/login?error=true";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String getRegister(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String postRegister(User user, BindingResult result, HttpSession session) {
		session.setAttribute("userTemp", user);
		return "redirect:/user/otp-auth";
	}

	@GetMapping("/otp-auth")
	public String getOtpAuth(HttpSession session) {
		User user = (User) session.getAttribute("userTemp");
		Random rand = new Random();
		String otp = String.format("%04d", rand.nextInt(9999) + 1111);
		System.out.println(otp);
		session.setAttribute("otp", otp);
		try {
			smsService.sendSms(user.getNumber(), otp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "otp-auth";
	}


	@PostMapping("/otp-auth")
	public String postOtpAuth(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String otp = request.getParameter("otp");
		String hashedOtp = (String) session.getAttribute("otp");
		if (otp.equals(hashedOtp)) {
			User user = (User) session.getAttribute("userTemp");
			user = userService.register(user);
			if (user != null) {
				session.setAttribute("user", user);
				return "redirect:/";
			}
		}
		return "redirect:/user/otp-auth";
	}
}
