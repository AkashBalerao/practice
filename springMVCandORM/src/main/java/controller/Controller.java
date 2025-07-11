package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import services.StoreService;

@org.springframework.stereotype.Controller
//@Component
public class Controller {

	@Autowired
	StoreService storeService;
	
//	@GetMapping("/")
//	public String getIndex() throws Exception {
//		
//			
//			try
//			{
//				throw new Exception();
//			}
//			catch(Exception e)
		
//			{
//				return "a";
//			}
//		throw new CustomException();
//		return "home";
//	}
	
//	@GetMapping("/index")
	@RequestMapping("/index")
	public String get(Map<String,Object> map) {
		map.put("count", storeService.StoresCount());
		return "index";
	}
}
