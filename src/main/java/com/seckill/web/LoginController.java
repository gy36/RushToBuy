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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seckill.dto.SeckillResult;
import com.seckill.entity.User;
import com.seckill.exception.register.PhoneExistException;
import com.seckill.exception.register.RegisterException;
import com.seckill.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {


	//调用server层
	@Autowired
	private UserService userService;


//	@RequestMapping(name="/login",method = RequestMethod.GET)
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String Login() {

		return "login";
	}

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
		
		long phone;
		String pwd="",rePwd = "";
		String strPhone="";
		ServletInputStream ss;

		strPhone = request.getParameter("phone");
		pwd = request.getParameter("pwd");
		rePwd = request.getParameter("repwd");
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
		 phone = Long.parseLong(strPhone);

		 //是否注册过
		 long s = userService.registerNewUser(phone,pwd);
		 


		return new SeckillResult(true,"账号错误");

	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public SeckillResult LoginV2(HttpServletRequest request) {
		
		long phone;
		long res;
		String pwd="",rePwd = "";
		String strPhone="";
		ServletInputStream ss;
		User user;

		strPhone = request.getParameter("phone");
		System.out.println(strPhone);

		rePwd = request.getParameter("repwd");
		pwd = request.getParameter("pwd");

		/***start 空值判断***/
		 if(strPhone == null || strPhone.length() == 0) {
			 
			 return new SeckillResult(false,"手机号缺失");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(false,"缺少密码");
		 }

		/***end 空值判断***/

	
		/***数据库判断***/
		 phone = Long.parseLong(strPhone);
		 
		//是否注册过
		 user = userService.getUserByAccount(phone);
		 if(user == null) {
			 
			 return new SeckillResult(false,"不存在账号");
		 }

		 boolean s = userService.canLogin(phone,pwd);

		 if(s == false) {
			 return new SeckillResult(false,"密码错误");
		 }

		 //保存session
		 HttpSession session = request.getSession();
		 session.setAttribute("user", user);

		return new SeckillResult(true,"成功");

	}


	@RequestMapping(value="/sign_v1",method=RequestMethod.POST)
	@ResponseBody
	public SeckillResult Signv1(HttpServletRequest request) {
		
		long phone;
		long res;
		String pwd="",rePwd = "";
		String strPhone="";
		ServletInputStream ss;
		User user;

		strPhone = request.getParameter("phone");
		System.out.println(strPhone);

		rePwd = request.getParameter("repwd");
		pwd = request.getParameter("pwd");

		/*
		 * {
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
		}
		*/

		/***start 空值判断***/
		 if(strPhone == null || strPhone.length() == 0) {
			 
			 return new SeckillResult(false,"手机号缺失");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(false,"缺少密码");
		 }

		 if(pwd == null || pwd.length() == 0) {
			 
			 return new SeckillResult(false,"缺少再次密码");
		 }

		/***end 空值判断***/

		/***逻辑值判断***/
		 if(pwd.equals(rePwd)) {
			 return new SeckillResult(false,"两次密码不同");
		 }

		 Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
		 Matcher m = p.matcher(strPhone);
		 if(!m.matches()) {
			 return new SeckillResult(false,"非法手机号");
		 }

		/***逻辑值判断结束***/

		/***数据库判断***/
		 phone = Long.parseLong(strPhone);
		 
		//是否注册过
		 user = userService.getUserByAccount(phone);
		 if(user != null) {
			 return new SeckillResult(false,"已经注册过");
		 }

		//注册
		 try {
			 	res = userService.registerNewUser(phone, pwd);
			 	if(res <=0 ) {
			 		return new SeckillResult(false,"注册失败");
			 	}
			 
		 }catch(PhoneExistException e1) {
			 	return new SeckillResult(false,"重复");
		 }catch(RegisterException e2) {
			 	return new SeckillResult(false,"注册失败");
		 }catch(Exception e3) {
			 	return new SeckillResult(false,"注册失败");
		 }

		return new SeckillResult(true,"成功");

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
