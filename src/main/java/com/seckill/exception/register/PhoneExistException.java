package com.seckill.exception.register;

public class PhoneExistException extends RuntimeException {
	public PhoneExistException(String message) {
		super(message);
	}
}
