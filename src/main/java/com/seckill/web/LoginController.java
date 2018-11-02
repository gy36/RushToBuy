package com.seckill.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seckill.dto.SeckillResult;

@Controller
@RequestMapping("/user")
public class LoginController {

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

	@RequestMapping("/signes")
	public String SignPages(HttpServletRequest request, HttpServletResponse response) {

        //HttpSession session = request.getSession();
        //String s = (String)session.getAttribute("name");
		return "sign";

	}


@RequestMapping("/signs")
	@ResponseBody
	public SeckillResult Sign(HttpServletRequest request) {
		
		int phone;
		String pwd="",rePwd = "";
		String strPhone="";
		ServletInputStream ss;

		strPhone = request.getParameter("phone");
		pwd = request.getParameter("pwd");
		rePwd = request.getParameter("repwd");
		System.out.println(strPhone);
		System.out.println(strPhone);
		System.out.println(request);
		System.out.println(rePwd);
		System.out.println(pwd);
		/***start 空值判断***/
		 if(strPhone == null || strPhone.length() == 0) {
			 
			 return new SeckillResult(true,"手机号缺失");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(true,"缺少密码");
		 }

		 if(rePwd == null || rePwd.length() == 0) {
			 
			 return new SeckillResult(true,"缺少再次密码");
		 }

		/***end 空值判断***/

		/***逻辑值判断***/
		 if(!pwd.equals(rePwd)) {
			 return new SeckillResult(true,"两次密码不同");
		 }

		 Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
		 Matcher m = p.matcher(strPhone);
		 if(!m.matches()) {
			 return new SeckillResult(true,"手机号不对");
		 }

		 //是否注册过

		//注册
		String wrong = "";

		//是否注册过

		return new SeckillResult(true,"账号错误");

	}


	@RequestMapping("/sign_v1")
	@ResponseBody
	public SeckillResult Signv1(HttpServletRequest request) {
		
		int phone;
		String pwd="",rePwd = "";
		String strPhone="";
		ServletInputStream ss;

		strPhone = request.getParameter("phone");
		System.out.println(strPhone);
		try {
			StringBuffer sb = new StringBuffer() ; 
			ss = request.getInputStream();
			System.out.println(ss);
			InputStreamReader isr = new InputStreamReader(ss); 
			BufferedReader br = new BufferedReader(isr); 
			String s = "" ; 
			while((s=br.readLine())!=null){ 
			sb.append(s) ; 
			} 
			String str =sb.toString();

			System.out.println(str);

			
		}catch(Exception e){
			System.out.println("出现错误");
			
		}
		rePwd = request.getParameter("repwd");
		pwd = request.getParameter("pwd");

		System.out.println(strPhone);
		System.out.println(request);
		System.out.println(rePwd);
		System.out.println(pwd);
		/***start 空值判断***/
		 if(strPhone == null || strPhone.length() == 0) {
			 
			 return new SeckillResult(true,"手机号缺失");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(true,"缺少密码");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(true,"缺少再次密码");
		 }

		/***end 空值判断***/

		/***逻辑值判断***/
		 if(pwd.equals(rePwd)) {
			 return new SeckillResult(true,"两次密码不同");
		 }

		 Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
		 Matcher m = p.matcher(strPhone);
		 if(!m.matches()) {
			 return new SeckillResult(true,"手机号不对");
		 }

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
