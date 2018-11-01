/**
 * 
 */
package com.seckill.gy;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:spring/spring-gy.xml")
public class BeanScopeTest { 

	@Resource(name="moocAspect")
    private BeanScope beanScope;

	@Resource(name="aspetBiz")
    private Gyconfig aspetBiz;

	@Test
	public final void testSay() {
		//ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		//ApplicationContext context = new FileSystemXmlApplicationContext("C://Users/gy/eclipse-workspace/RushToBuy/src/main/resources/spring/spring-gy.xml");
		//context.getBean("BeanScope");
		aspetBiz.dosth("zh",19);
		System.out.println("hello");
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSays() {
	//	beanScope.say();
		System.out.println("hello");
		//fail("Not yet implemented"); // TODO
	}

}
