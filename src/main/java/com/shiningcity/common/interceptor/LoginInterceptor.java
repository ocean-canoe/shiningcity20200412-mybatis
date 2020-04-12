package com.shiningcity.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//登录认证拦截器
public class LoginInterceptor implements HandlerInterceptor {
	//Handler执行完之后，调用这个方法
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	//Handler执行完之后，ModelAndView返回之前，调用这个方法
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}
	//Handler执行之前调用这个方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//获取请求的URL
		String url = request.getRequestURI();
		//对于longin.jsp直接放行
		if(url.indexOf("login.do")>=0){
			return true;
		}
		//获取session
		HttpSession session = request.getSession();
		//String username = session.getAttribute("username").toString();
		String username = (String)session.getAttribute("username");
		if(username!=null){
			return true;
		}else{
			//如果没有登录，则跳转到登录页面
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return false;
		}
	}

}
