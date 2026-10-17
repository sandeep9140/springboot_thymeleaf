package com.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/about")
	public String showabout() {
		return "about";
	}
	
	
	@GetMapping("/contact")
	public String showContact() {
		return "contect";
	}

}
