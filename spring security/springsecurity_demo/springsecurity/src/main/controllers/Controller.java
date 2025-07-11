package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import services.StoreService;

@org.springframework.stereotype.Controller
//@Component
public class Controller {
	@RequestMapping("/index")
	public String get() {
		return "index";
	}
}
