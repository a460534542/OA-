package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 1) implements HandlerInterceptor
// 2) extends HandlerInterceptorAdapter
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if ( request.getSession().getAttribute("user") ==null  ) {
			// 未登录，拦截
			System.out.println( "未登录，被拦截" );
			response.sendRedirect( request.getContextPath() + "/user/login");
			return false;
		} 
		System.out.println( "已登录，放过" );
		return true;
	}

}
