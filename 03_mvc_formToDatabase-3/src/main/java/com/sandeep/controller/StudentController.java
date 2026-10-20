package com.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sandeep.entities.Students;
import com.sandeep.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService serviceStudent;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("stu", new Students());
		return "register";
	}
	
	@PostMapping("/save")
	public String saveMethod(@ModelAttribute Students student) {
		serviceStudent.saveuser(student);
		return "redirect:/";
	}
	

}
