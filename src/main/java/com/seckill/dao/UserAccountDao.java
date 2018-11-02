package com.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.User;

public interface UserAccountDao {
	
	User loginUserByAccount(@Param("user_accout") long seckillId);

}
