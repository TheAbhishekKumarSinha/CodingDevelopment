package org.springhibernate.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptors implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exp)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INTERCEPTOR WORKING");
		if(request.getContextPath().contains("login")){
			System.out.println("INTERCEPTOR WORKING");
			return true;
		}
		else{
			HttpSession session=request.getSession(false);
			if(session!=null){
				request.setAttribute("errorMsg", "Please Login Again");
				return false;
			}
			if(request.getParameter("userid").equals((String)session.getAttribute("userid"))){
				return true;
			}
			else
				return false;
		}
		
	}

}
