package com.seckill.gy;

import org.aspectj.lang.ProceedingJoinPoint;

public class BeanScope {

	public void say() {
		System.out.println("beenscope sya"+this.hashCode());

	}

	public void before() {
		System.out.println("before ::"+this.hashCode());

	}
	public void after() {
		System.out.println("after"+this.hashCode());

	}
	
	public Object around(ProceedingJoinPoint pjp,String name,int age) {
		Object obj = null;
		System.out.println(" around name:"+name+"  age:"+age);
		try {
			System.out.println("¿ªÊ¼");
			obj = pjp.proceed();
			System.out.println("½áÊø");
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return obj;

	}

	public void start() {
		System.out.println("start beenscope sya"+this.hashCode());
	}

	public void end() {
		System.out.println("end beenscope sya"+this.hashCode());
	}
}

