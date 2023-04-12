package com.example.demo6.handler;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo6.dto.CustomError;

@RestControllerAdvice // Ioc 의 대상이 된다
// @ControllerAdvice // 페이지 리턴 오류시 작동
public class GlobalControllerAdvice {

	// 모든 예외를 여기서 처리하고 싶다면
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {

		System.out.println("=======================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("=======================");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

	}

	// 특정 예외를 잡아서 다르게 응답처리하고싶다면
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		// StringBuilder 사용했었음
		//StringBuilder sb = new StringBuilder();

		// 데이터 가공해서 적절하게 응답 만들어
		List<CustomError> errorList = new ArrayList<>();
		e.getAllErrors().forEach(error -> {

			String field = error.getCode();
			String message = error.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(field);
			customError.setMessage(message);
			errorList.add(customError);
					

//			sb.append("코드 :" + error.getCode());
//			sb.append("\n");
//			sb.append("message :" + error.getDefaultMessage());

		});
		// 디버깅
		// 필드가 잘 못 되었는지
		// 메세지
		// String 값으로 재정의해서 응답처리해주세요

		System.out.println("잘못된 값 입력");

		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);

	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {

		System.out.println("잘못된 형식 : 제이슨 문법 아직도 모루냐");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

	}

	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<?> bindException(BindException e) {

		System.out.println("Get 방식으로 던질 떄 값을 잘못 던졌네");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

	}

}
