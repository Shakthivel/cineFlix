package com.cineFlix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineFlix.model.User;
import com.cineFlix.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLogin() {
		return "user-login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String postLogin(@RequestParam("name") String name, @RequestParam("password") String password,
							HttpSession session) {
		User u = userService.login(name, password);
		session.setAttribute("user", u);
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
		if (result.hasErrors()) {
			return "user-register";
		}

		// Directly register the user without OTP
		user = userService.register(user);

		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/";
		}
		return "redirect:/user/register?error=true";
	}
}
