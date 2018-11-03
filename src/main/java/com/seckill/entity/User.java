package com.seckill.entity;

public class User {
	private long Id;
	private String userAccount;
	private String userPwd;
	private String gmtModified;
	private String gmtCreate;

	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}

	public String getPwd() {
		return userPwd;
	}
	public void setPwd(String pwd) {
		userPwd = pwd;
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
	@Override
	public String toString() {
		return "User [Id=" + Id + ", userAccount=" + userAccount + ", userPwd=" + userPwd + ", gmtModified="
				+ gmtModified + ", gmtCreate=" + gmtCreate + "]";
	}

}
