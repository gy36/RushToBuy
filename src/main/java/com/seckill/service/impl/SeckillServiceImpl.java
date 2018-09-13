package com.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessKilled;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;

@Service
public class SeckillServiceImpl implements SeckillService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillDao seckillDao;

	@Autowired
	private SuccessKilledDao successKilledDao;

	private final String slat = "asdhkfaksd";

	private String getMD5(long seckillId) {
		
		String base = seckillId+ "/"+slat;

		String  md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;

	}

	@Override
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(Long seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(Long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		// TODO Auto-generated method stub
		if(seckill == null) {
			return new Exposer(false,seckillId);
		}

		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();

		Date nowTime = new Date();

		if(nowTime.getTime() < startTime.getTime()
			|| nowTime.getTime() >endTime.getTime()) {
			return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}

		String md5 = getMD5(seckillId);
		return new Exposer(true,md5,seckillId);
	}

	@Override
	public SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckillProcedure(Long seckillId, Long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		// TODO Auto-generated method stub
		if(md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite!");
		}
		//Ö´ÐÐÇÀ¹ºÂß¼­£º¼õ¿â´æ +¼ÇÂ¼¹ºÂòÐÐÎª
		Date nowTime = new Date();

		//¼õ¿â´æ
		int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
		try {
			
			if(updateCount <=0) {
				throw new SeckillCloseException("seckill is closed");
			}else {
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if(insertCount <= 0) {
					throw new RepeatKillException("seckill repeated");
				}else {
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId,userPhone);

					return new SeckillExecution(seckillId,1,"ÃëÉ±³É¹¦",successKilled);

				}
			}
		} catch(SeckillCloseException e1) {
			throw e1;
		}catch(RepeatKillException e2) {
			throw e2;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new SeckillException("seckill inner error"+ e.getMessage());
		}

	}

	
}
