package com.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.Seckill;

public interface SeckillDao {


	/**
	 * ¼õ¿â´æ
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

	/**
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	List<Seckill> queryAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
