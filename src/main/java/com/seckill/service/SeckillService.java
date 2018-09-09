package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by wchb7 on 16-5-13.
 * ҵ��ӿ�:վ��"ʹ����"�ĽǶ���ƽӿ�
 * 1.�����Ķ��������.2.����.3.��������(return /�쳣)
 */
public interface SeckillService {


    /**
     * ��ѯ������ɱ��¼
     *
     * @return
     */
    List<Seckill> getSeckillList();


    /**
     * ��ѯ������ɱ��¼
     *
     * @param seckillId
     * @return
     */
    Seckill getById(Long seckillId);


    /**
     * ��ɱ����ʱ�����ɱ�ӿڵ�ַ
     * �������ϵͳʱ�����ɱʱ��
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(Long seckillId);

    /**
     * ִ����ɱ����
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) throws SeckillException
            , RepeatKillException, SeckillCloseException;

    /**
     * ִ����ɱ���� by �洢����
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckillProcedure(Long seckillId, Long userPhone, String md5);

}
