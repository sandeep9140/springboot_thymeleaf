package com.sandeep.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandeep.Employee;

@Controller
public class EmployeeController {
	@GetMapping("/")
	public String showEmp(Model model) {
		List<Employee> list=List.of(
				new Employee("sandeep", "admin"),
				new Employee("pradeep", "user"),
				new Employee("vinnu", "sadmin"),
				new Employee("deep", "admin"),
				new Employee("deepu", "user"),
				new Employee("ep", "admin")
				);
		
		model.addAttribute("emp", list);
		return "employees";
		
	}

}
