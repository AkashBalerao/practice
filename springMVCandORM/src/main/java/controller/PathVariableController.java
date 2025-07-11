package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	@RequestMapping("/path/{id}")
	public String path(@PathVariable("id") int id) {
		return "path";
	}
}
