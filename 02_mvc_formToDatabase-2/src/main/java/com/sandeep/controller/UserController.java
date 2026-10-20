package com.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/")
	public String showUser() {
		return "home";
	}
	
	public String saveUser() {
		return "redirect:/";
	}

}
