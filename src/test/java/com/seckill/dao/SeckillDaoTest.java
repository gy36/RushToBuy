package com.seckill.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.seckill.entity.Seckill;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    private SeckillDao seckillDao;
	@Test
	public void testReduceNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

}
