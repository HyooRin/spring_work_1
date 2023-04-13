package com.example.greenBlog.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	// http://localhost:8080/blog
	@GetMapping({"blog"})
	public String userPage() {		
		
		 
		
				
				
		return "blog";		
	}


}
