package com.example.demo101.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo101.dto.User;

@Controller
public class UserController {
	
	// http://localhost:8080/loginPage
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "login";
		
	}
	
	@PostMapping("/loginProc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		return "info";		
	}
	
	@GetMapping("")
	public String infoPage(HttpServletRequest request) {
		
		return "";
	}
	
	
	
	
	
	

}
