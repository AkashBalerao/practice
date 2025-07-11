package controller;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Student;

@Controller
public class StudentController {

	@GetMapping("/studentform")
	public String studForm(@ModelAttribute Student student) {
		return "studentform";
	}
	
	@PostMapping("/regstudent")
	public String registerStudent(@Validated @ModelAttribute  Student student , BindingResult result) {
		if(result.hasErrors()) {
			return "studentform";
		}
		else {
			return "success";
		}
	}
}
