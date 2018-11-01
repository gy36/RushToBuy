package com.seckill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class User {

//	@RequestMapping(name="/login",method = RequestMethod.GET)
	@RequestMapping("/login")
	public String Login() {

		return "login";

	}

	@RequestMapping("/sign")
	public String SignPage() {

		return "sign";

	}

}
