package com.example.demo5.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated // GET 방식일때 반드시 선언해주어야 유효성 검사를 시작한다
public class UserController {

	// GET 방식일때 파라미터 앞에 어떤 유효성 검사를 할때 당연히 지정해주어야 한다

	// http://localhost:8080/user?name=홍&age=1
	// Get 방식일때 valid 처리
	@GetMapping("/user")
	public User user(@Size(min = 2) @RequestParam String name, @NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
	
	// 문제 GET 방식으로 유효성 검사 만들어 보기
	@GetMapping("/user1")
	public User user(@Size(max = 3) @RequestParam String name, @NotNull @Email @RequestParam String email) {
		
		User user1 = new User();
		user1.setName(name);
		user1.setEmail(email);
		
		return user1;
		
	}
	// http://localhost:8080/user2?name=홍&age=1
	@GetMapping("/user2")
	// object mapper 통해서 파싱 처리하고 싶다면
	public User user2(@Validated User user) {
		
		return user;
	}

}
