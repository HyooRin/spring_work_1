package com.example.demo101.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		
		if( user == null ) {
			System.out.println("인증안된 사용자");
			response.sendRedirect("/login");
			return false;
		}
		
		
		return true;
	}

}
