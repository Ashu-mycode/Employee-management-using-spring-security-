package com.example.Employeeemanagement.controller;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableCaching
@Controller
public class MainController {
	
	//for logger file
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//This main Controller for first opened 
	/*@GetMapping("/login")
	public String login() {
		logger.trace("FATAL ERROR");
		return "login";
	}*/

	//This main Controller for first opened login form spring security 
	@GetMapping("/login")
	public String showLoginPage() {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null  || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		
		return "redirect:/";
		
	}
}
