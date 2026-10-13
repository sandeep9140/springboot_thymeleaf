package com.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("msg","welcome to home");
		
		return "home";
	}

}
