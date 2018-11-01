package com.seckill.gy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodGY implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("hehe");

	}

}
