package com.example.demo51.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo51.dto.User;
@RestController
@RequestMapping("/api2")
public class ApiController {
	
	// http://localhost:8080/api2/user
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user){
		
		
		if(user.getAge() > 20 ) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
			
			
		}
		
		System.out.println(user);
		return ResponseEntity.ok(user);
		
	}
	
	// build 패턴 User 객체 만들어보기(마지막에 build() 반드시 호출)
	User user2 = User.builder().email("").age(12).build();
	

}
