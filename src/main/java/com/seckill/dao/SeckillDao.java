package com.seckill.dao;

import java.util.Date;
import java.util.List;
import com.seckill.entity.Seckill;

public interface SeckillDao {


	/**
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);

	/**
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);

	List<Seckill> queryAll(int offet,int limit);

}
