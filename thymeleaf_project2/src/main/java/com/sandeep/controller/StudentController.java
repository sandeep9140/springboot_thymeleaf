package com.sandeep.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandeep.model.Students;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String getStudents(Model model) {
		
		Students e1=new Students(101, "sandeep", 21);
		
		model.addAttribute("obj",e1);
		
		return "students";
	}

}
