package src.main.java.hu.me.iit.webalk.first;

import org.springframework.stereotype.controller;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	String gyoker() {
		return "Hello there";
	}
	
	

}
