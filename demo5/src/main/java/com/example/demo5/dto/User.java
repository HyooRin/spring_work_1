package com.example.demo5.dto;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	private String name;
	@Min(message = "10세 미만 안됩니다", value=10)
	private int age;
	@javax.validation.constraints.Email(message = "넌 이메일 형식도 모르니")
	private String email;
	private String phoneNumber;

}
