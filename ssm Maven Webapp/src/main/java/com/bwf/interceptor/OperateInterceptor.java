package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Operate;
import com.bwf.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 获取 请求中的 url 地址 
		
		// /oa/roster/show
		System.out.println( request.getRequestURI() );
		
		boolean sessionContainsUri = false;
		User user = (User) request.getSession().getAttribute("user"); 
		for( Operate o : user.getOperates() ) {
			if ( request.getRequestURI().contains( o.getOperateAction() ) ) {
				sessionContainsUri = true;
			}
		}
		
		// 判断 用户 session.user.operates 中 是否 含有 roster/show
		if ( sessionContainsUri ) {
			return true;
		} else {
			response.sendRedirect( request.getContextPath() + "/error");
			return false;
		}
	}
}
