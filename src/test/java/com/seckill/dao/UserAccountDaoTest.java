package com.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserAccountDaoTest {

	@Resource
    private UserAccountDao userDao;

	@Test
	public void testLoginUserByAccount() {
		long phone = 1000;
        User user = userDao.loginUserByAccount(phone);
        System.out.println(user);
	}

	@Test
	public void testRegisterNewUser() {
		java.text.SimpleDateFormat f= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long user_phone = 131;
		String  user_pwd = "pwd";
		long res = 0;
		Date now = new Date();
		Date gmt_modified =now, gmt_create = now;
		//System.out.println(f.format(now));

		res = userDao.registerNewUser(user_phone,user_pwd,now,(now));
			

		System.out.println("主键"+res);


	}

	@Test
	public void testRegisterNewUserV2() {
		java.text.SimpleDateFormat f= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(f.format(now));
		User user = new User();
		user.setPwd("123");
		user.setUserAccount("1822051");

		System.out.println("展示");
		System.out.println(user);
		System.out.println("展示");
		userDao.registerNewUserV2(user);

		System.out.println("主 da键"+user.getId());


	}


}
