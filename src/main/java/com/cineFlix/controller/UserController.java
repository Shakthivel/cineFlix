package com.cineFlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String postLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
		// TODO: User authentication
		User u = userService.login(name, password);
		if (u != null) {
			return "redirect:/welcome";
		}
		return "user-login";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String getRegister(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String postRegister(User user, BindingResult result) {

		User u = userService.register(user);
		System.out.println(u);
		return "index";
	}
}
