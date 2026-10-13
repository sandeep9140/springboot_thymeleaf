package com.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	int count=0;
	@GetMapping("/login")
	public String loginGet(Model model) {
		count++;
		model.addAttribute("times",count);
		
		
		return "login";
	}
	
	@GetMapping("/song")
	public String songPlay() {
		return "song";
	}

}
