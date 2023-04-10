package com.example.demo2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// http://localhost:8080/user/info
	@GetMapping
	public void info() {
		System.out.println("여기는 method get 방식입니다");
	}
	
	// http://localhost:8080/user/info
	@PostMapping
	public void info2() {
		System.out.println("여기는 method post 방식입니다");
		
	}
	
	// http://localhost:8080/user/info
	@PutMapping
	public void info3() {
		System.out.println("여기는 method put 방식입니다");
	}
	
	// http://localhost:8080/user/info
	@DeleteMapping
	public void info4() {
		System.out.println("여기는 method delete 방식입니다");
		
	}

}
