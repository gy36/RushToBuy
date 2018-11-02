package com.seckill.entity;

public class User {
	private String UserAccount;
	private String UserPwd;
	private String gmtModified;
	private String gmtCreate;
	public String getUserAccount() {
		return UserAccount;
	}
	public void setUserAccount(String userAccount) {
		UserAccount = userAccount;
	}
	public String getPwd() {
		return UserPwd;
	}
	public void setPwd(String pwd) {
		UserPwd = pwd;
	}
	public String getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

		
}
