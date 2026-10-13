package com.sandeep.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandeep.model.Students;

@Controller
public class StudentController {
	
	@GetMapping("/data")
	public String studentdata(Model model) {
		
		List<Students> list=List.of(
				new Students("sandeep", 12),
				new Students("vijay", 22),
				new Students("pradeep", 32)
		);
		
		model.addAttribute("stu", list);
		
		
		return "data";
	}

}
