package com.example.demo10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo10.dto.User;

@Controller
public class UserController {

	@GetMapping("/loginPage")
	public String loginPage() {

		return "login.html"; // 내부에서 이동
	}
	
	@PostMapping("/loginProc")
	public String loginProc(HttpServletRequest requset, HttpServletResponse response, User user) {
		
		HttpSession session = requset.getSession();
		session.setAttribute("principal", user);
		
		//return "redirect:/info.html";
		return "redirect:/auth/infoPage";
	}

	/*
	 * 인증된 사용자만 들어올 수 있게 막을 예정
	 * AuthInterceptor 동작 시킬려면 주소 설계를 /auth/**
	 * */
	
	@GetMapping("/auth/infoPage")
	public String infoPage(HttpServletRequest request) {
		// 테스트 
		// todo! 
		// 1. 아래부분 삭제예정
		// 2. 인터셉터가 동작하도록 주소 변경 예정  
		
//		HttpSession session = request.getSession();		
//		Object principal = session.getAttribute("principal");		
//		if( principal == null) {
//			return "redirect:/loginPage";
//		}
		System.out.println("여기 코드 실행하려면 로그인 돼야 함");
		// 상대위치 들어왔으면 -> 현재 그 시점에서 맞게 설계해야 됨 
		// 위치에서 상대 경로 찾을지 절대 경로로 찾을지 결정 
		
		//return "info.html";
		
		// -> http://localhost:8080/info.html URL
		// 목적지 /info.html - ok
		// 누구나 접근할 수 있더 
		// http://localhost:8080/info.html
		// 목적지는 맞으나 현재 URL 접근 방식은 Controller 안탐 
		// --> 인터 셉터 동작 안함 
		return "/info.html";
		
		
		// ***********************
		// -> http://localhost:8080/auth/info URI
		// redirect <- 어디까지 갔다오냐면 (브라우저로 돌아갔다옴)
		// 새로운 request와 response 객체가 만들어진다 
		//return "redirect:/auth/info"; // 확인
	}
	
	
}
