package com.seckill.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.User;

public interface UserAccountDao {
	
	User loginUserByAccount(@Param("user_accout") long user_phone);

	long registerNewUser(@Param("user_phone") long user_phone,@Param("user_pwd") String user_pwd,
				@Param("gmt_modified") Date gmt_modified,@Param("gmt_create") Date gmt_create 
			);

	long registerNewUserV2(User user);

}
