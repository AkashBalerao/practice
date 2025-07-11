package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/accessdenied")
	public String accessDenied() {
		return "accessdenied";
	}
}
