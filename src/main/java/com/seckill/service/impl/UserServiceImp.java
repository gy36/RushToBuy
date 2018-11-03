package com.seckill.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seckill.dao.UserAccountDao;
import com.seckill.entity.User;
import com.seckill.exception.register.PhoneExistException;
import com.seckill.exception.register.RegisterException;
import com.seckill.service.UserService;

@Service
public class UserServiceImp implements UserService{


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserAccountDao userDao;

	@Override
	public User getUserByAccount(long phone) {
		return userDao.loginUserByAccount(phone);
	}

	@Override
	public long registerNewUser(long user_phone,String user_pwd) 
			throws PhoneExistException,RegisterException{

		long res = 0;
		Date now = new Date();
		Date gmt_modified =now, gmt_create = now;

		User user = getUserByAccount(user_phone);

		if(user != null) {
			throw new PhoneExistException("该号码已经注册过");
		}

		try {
			res = userDao.registerNewUser(user_phone, user_pwd, gmt_modified, gmt_create);

			if(res <=0) {
				throw new PhoneExistException("该号码已经注册过");
			}

		}catch(PhoneExistException e1) {
			throw e1 ;
		}catch(Exception e2) {
			logger.error(e2.getMessage(),e2);
			throw new RegisterException("seckill inner error"+ e2.getMessage());
		}

		return res;
	}

}
