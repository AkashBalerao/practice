package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PasswordValidator {

	@GetMapping("/form")
	public String form() {
		return "passwordform";
	}
	
	@PostMapping("/validatePassword")
	@ResponseBody
	public Map<String, Boolean> validatePassword(@RequestBody Map<String, String> request) {
//		System.out.println("hello");
	    String password = request.get("password");
	    Map<String, Boolean> result = new HashMap<>();

	    result.put("1", password != null && !password.trim().isEmpty());
//	    result.put("2", password != null && !password.matches("^[\\d\\W].*")); // does NOT start with digit or special
	    result.put("3", password != null && password.matches(".*[A-Z].*")); // has capital letter
	    result.put("4", password != null && password.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~-].*")); // has special
	    result.put("5", password != null && password.length() >= 8); // minimum 8 characters
	    
//	    //rule 1 must not be empty
//	    result.put("1", password.isEmpty());
//	    
	    //rule2 first letter must not be 
	    if(password!=null && password.length()>=1) {
	    	
	    	char ch= password.toLowerCase().charAt(0);
	    	
	    	if(Character.isLowerCase(ch)) {
	    		result.put("2", true);
	    	}
	    	else {
	    		result.put("2", false);
	    	}
	    }
	    else {
	    	
	    	result.put("2", false);
	    }
//	    
//	    //rule 3
	    

	    return result;
	}
	
	@PostMapping("/passwordregister")
	public String succespage(@RequestParam String password , Map<String,Object> map) {
		map.put("password", password);
		return "successpassword";
	}

}
