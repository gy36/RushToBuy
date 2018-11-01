package com.seckill.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seckill.dto.SeckillResult;

@Controller
@RequestMapping("/user")
public class User {

//	@RequestMapping(name="/login",method = RequestMethod.GET)
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String Login() {

		return "login";

	}

@RequestMapping(value = "/login",method=RequestMethod.POST)
	public SeckillResult toLogin() {

		//登陆账号

		return new SeckillResult(true,"账号错误");

	}


	@RequestMapping("/sign")
	public String SignPage() {

        //HttpSession session = request.getSession();
        //String s = (String)session.getAttribute("name");
        
		return "sign";

	}

	@RequestMapping(value = "/sign",method=RequestMethod.POST)
	public SeckillResult Sign(int phone, String psw) {

		//注册
		String wrong = "";

		//是否注册过
		
		


		return new SeckillResult(true,"账号错误");

	}


	/*
	@RequestMapping("/session")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", "longestory");
        System.out.println("已经成功向HttpSession对象中存储了共享数据内容name=longestory...");
    }
    */

}
