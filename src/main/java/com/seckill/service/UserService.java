package com.seckill.service;

import java.util.Date;

import com.seckill.entity.User;
import com.seckill.exception.register.PhoneExistException;
import com.seckill.exception.register.RegisterException;

public interface UserService {

	 User getUserByAccount(long phone);

	 long registerNewUser(long user_phone,String user_pwd) 
			 throws PhoneExistException,RegisterException;

}
