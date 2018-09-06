package com.seckill.dao;

import com.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

	int insertSuccessKilled(long seckillId,long userPhone);

	SuccessKilled queryByIdWithSeckill(long seckillId);

}
