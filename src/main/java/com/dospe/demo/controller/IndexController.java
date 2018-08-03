package com.dospe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String showWelcome() {
		return "welcome-server-pagination";
	}
	
}
