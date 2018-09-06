package com.seckill.dto;

public class Exposer {
	private boolean exposed;

	private String md5;

	private long seckillId;

	private long now;

	private long start;

	private long end;

	@Override
	public String toString() {
		return "Exposer{" +
				"exposed=" +exposed+
				",md5='" + md5 + '\''+
				",seckillId=" +seckillId +
				",now=" +now +
				",start="+start+
				",end="+end+
				 "}";
	}


}
