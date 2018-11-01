package com.seckill.gy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Gyconfig {

	public void say() {
		System.out.println("beenscope sya"+this.hashCode());

	}

	public void dosth(String name,int age) {
		System.out.println("name:"+name+"  age:"+age);
	}
}
