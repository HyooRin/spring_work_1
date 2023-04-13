package com.example.demo9.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo9.dto.User;

@Controller
public class UserController {

	// 1. 로그인 페이지 직접 URL 요청해서 응답 받을 수 있다(사전지식)
	// 2. 로그인페이지를 controller 타서 응답처리해보자
	@GetMapping("/login-page")
	public String login() {

		return "login.html";
	}

	// MIME TYPE form:x--
	// @RequestBody <-- appication/json
//	@PostMapping("/login-proc")
//	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
//		// 로직 : 세션 저장 후 myInfo 페이지 이동처리함
//		HttpSession session = request.getSession();
//		System.out.println("user:" + user);
//		session.setAttribute("user", user);
//		// response.sendRedirect("/mypage/myinfo");
//		return "redirect:/mypage/myinfo.html";
//	}
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		HttpSession session = request.getSession();
		System.out.println("user:" + user);
		session.setAttribute("user", user);
		
		return "redirect:/mypage/cart.html";
	}

	// myinfo 설계
	// http://localhost:8080/mypage/myinfo 로 설계해야 인터페이스 동작됨
	@GetMapping("/mypage/myinfo")
	public String myinfo() {
		// 인증이 필요한 페이지로 만들기로 함
		return "mypage/myinfo.html";
	}
	
	// cart 
	// http://localhost:8080/mypage/cart
	@GetMapping("/mypage/cart")
	public String cart() {

		return "mypage/cart.html";

	}

}
