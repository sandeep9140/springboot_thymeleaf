package com.sandeep.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandeep.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String showStudent(Model model) {
		
		List<Student> list=List.of(
				new Student("sandeep", 21),
				new Student("pankaj", 22),
				new Student("ankit", 23),
				new Student("billa",24),
				new Student("taklu", 3),
				new Student("pinda", 24),
				new Student("ankur", 32)
				);
		
		model.addAttribute("stu",list);
		
		return "students";
		
	}

}
