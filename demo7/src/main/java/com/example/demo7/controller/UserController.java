package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 페이지 리턴해줄 때 
public class UserController {
	
	// 페이지 리턴은 스트링 사용
	// http://localhost:8080/
	// http://localhost:8080/user
	@GetMapping({"/","user"})
	public String userPage(Model model) {		
		
		// yml 파일 설정
		// prefix : /WEB-INF/view/
		// suffix: .jsp
		//return "/WEB-INF/view/user.jsp"; <- 가 완성됨 
		// ViewResolver가 동작해서 페이지를 찾고 리턴 
		
		//데이터를 내려보내고 싶다면		
		model.addAttribute("principal", "헬로우!");		
		return "user";		
	}

}
