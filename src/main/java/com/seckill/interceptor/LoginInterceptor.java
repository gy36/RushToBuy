package com.seckill.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.seckill.entity.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();    
        System.out.println("post URL："+url);

        //免登陆接口 
        //登陆和注册
        if(url.endsWith("/user/login") || url.endsWith("/user/register")){
        	return true;
        }
        

        if(!url.equals("")){
            //判斷是否已登录
            User loginUser = (User)request.getSession().getAttribute("user");
            if(loginUser == null){
                //無session則是未登录狀態
                System.out.println(">>>未登录，請重新登录<<<");
                response.sendRedirect("/user/login");
                return false;
            }
            
		}

		return true;
	}
 
}