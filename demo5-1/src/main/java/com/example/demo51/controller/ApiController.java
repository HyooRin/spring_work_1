package com.example.demo51.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo51.dto.User;
@RestController
@RequestMapping("/api2")
public class ApiController {
	
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user){
		// spring boot 요청시(request) 데이터 기본 파싱 전략은 key=value 구조
		// dto <- object mapper 동작을 해서 자동 파싱해서 처리해야 한다 
		// 유효성 검사 (예전방식)
		if(user.getAge() < 1 || user.getAge() > 100) {
			// 잘못된 입력 값 확인 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		// 서비스 만들어(로직) -> DAO 던저서 (DB insert)
		// 정방향 갔다가 -> 역방향으로 돌아온다 -> 응답 처리해주면 됨 
		
		
		return ResponseEntity.ok(user);		
	}
	
	// 두번째 연습
	// AOP 기반인 @validation 라이브러리 활용하기 
	// 1. GET 방식일때 사용방법과 POST 방식일떄 사용방법이 약간다르다
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@RequestBody User user){
		
		// 관점 지향 패러다임 추가 
		// AOP 기반에 valid 라이브러리를 활용하면 공통적으로 들어가야하는 부분에 
		// 코드를 분리시킬 수 있다
		
		return ResponseEntity.ok(user);
	}
	// 와일드 카드 -> ? 사용가능 (상황에 따라 결과값이 다를때 쓰장)
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@RequestBody User user, BindingResult bindingResult){
		// bindingResult 클래스를 배워보자
		// bindingResult가 @Valid에 대한 결과 값을 가지고 있다
		if(bindingResult.hasErrors()) {
			// 에러발생(T)
			// 필드 - 어떤 필드에서 에러 발생 
			// 메세지 내용 반환 처리
			StringBuilder sb = new StringBuilder();
			
			bindingResult.getAllErrors().forEach(error -> {
				
				System.out.println(error.getCode());
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getArguments());
				System.out.println(error.getObjectName());
				
				sb.append("field :" + error.getCode());
				sb.append("\n");
				sb.append("message :" + error.getDefaultMessage());
				sb.append("\n");
				
			});
			
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		// 정상처리(F)			
		return ResponseEntity.ok(user);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
