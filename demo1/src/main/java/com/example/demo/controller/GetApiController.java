package com.example.demo.controller;

import java.util.Map;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

// @Controller <- 화면 응답 (HTML(jsp))
@RestController // <- JSON 방식으로 응답 처리된다
@RequestMapping("/api")
public class GetApiController {
	
	// 주소 설계 - GET 방식 
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}
	
	// 쿼리 파람 방식으로 데이터를 파싱해서 처리하자 
	// http://localhost:8080/api/queryParam1?name=홍아
	@GetMapping("/queryParam1")
	public String queryParam1(@RequestParam String name) {
		System.out.println("name >>" + name);
		return "name :" + name;
	}
	
	// 1. http://localhost:8080/api/queryParam2?name=홍아&age=10
	// 2. http://localhost:8080/api/queryParam2?name=홍아
	// 쿼리 스트링 방식으로 주소설계를 서버에서 했다면 요청시에 정확히 맞추어 주어야 한다.
	// 아니면 오류 발생 (하지만 선택적 요소로 만들 수도 있다)
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name, 
			@RequestParam(required = false, defaultValue = "0" ) int age) {
		System.out.println("name :" + name);
		System.out.println("age :" + age);
		
		return "name,age : " + name;
	}
	// http://localhost:8080/api/queryParam3?name=홍아&age=10
	// http://localhost:8080/api/queryParam3?name=홍아&age=10&groupId=com.tenco
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach( entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		System.out.println("data : " + data.toString());
		
		return "파싱 map 방식에 이해" + sb.toString();
	}
	
	// Map 활용 (직접 만들어보기) 
	
	// http://localhost:8080/api/query?name=횰니&age=23
	@GetMapping("/query")
	public String query(@RequestParam Map<String, String> info) {
		
		info.entrySet().forEach( entry -> {
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();			
		});
		
		return "info :" + info ;
		
	}
	
	// 주소 : GET 방식 
	// http://localhost:8080/api/queryParam4?name=홍아&age=10&email=a@naver.com
	// 메세지 컨버터 동작해서 자동으로 파싱처리
	// @RequestMapping 붙이지 말아야한다
	// dto에 속성값이 없으면 파싱을 하지 않는다
	
	@GetMapping("/queryParam4")
	public String queryParam4(UserRequest userDto) {
		System.out.println("dto 방식 동작 처리");
		
		System.err.println(userDto.getName());		
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		
		return userDto.toString();
		
	}
	
	//pathVariable 방식
	// http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable(@PathVariable int userId) {
		System.out.println("userId" + userId);
		
		return "userId :" + userId;
		
	}
	
	// 변수명을 똑같이 사용하지 못 할떄 옵션 값을 지정할 수 있다. 
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name = "name") String mName ) {
		String name = "내부에서 name 변수명이 있어요";
		
		return "name : " + mName;
	}
	
	// GET 방식 
	// http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}")
	public String getOrder(@PathVariable int userId, @PathVariable int orderId) {
		
		return "userID :" + userId + "," + orderId;
	}
	
	// http://localhost:8080/api/name/홍아
	// DTO 맵핑은 @PathVariable 선언 없이 사용하자 
	// DTO 안에 맵핑할 변수와 키값이 같아야 한다
	@GetMapping("/name/{userName}")
	public UserRequest getUser(UserRequest dto) {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		
		
		return userRequest;
		
	}
	

}
