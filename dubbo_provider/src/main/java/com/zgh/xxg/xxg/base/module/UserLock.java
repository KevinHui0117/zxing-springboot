package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserLock")
public class UserLock extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String LOCK_TYPE_PASSWORD="1";
	public static final String STATUS_LOCK="1";
	public static final String STATUS_UNLOCK="0";
	public static final String UNLOCK_AUTO="1";
	public static final String UNLOCK_HAND="2";
	
	
	private long userId;  //用户ID
	private String  status;		//状态
	private String  lockTime;		//锁定时间
	private String lockType;		// 锁定类型
	private long lockerId;		//锁定人
	private int lockMinute;		//锁定时长 -1表示长期锁定
	private  String unlockType;		//解锁类型
	private String  unlockTime;		//解锁时间
	private long  unlockerId;		//解锁人ID
	
	//以下信息不存数据库
	private String  fullName;		//名称或姓名
	private String  idcardCode;		//身份证件号码
	private String mobile;		//手机号码
	private String lockerName;			//锁定人姓名
	private String unlockerName;	//解锁人姓名
	private String userType;	//用户类型
	

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLockTime() {
		return lockTime;
	}
	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}
	public String getLockType() {
		return lockType;
	}
	public void setLockType(String lockType) {
		this.lockType = lockType;
	}
	public long getLockerId() {
		return lockerId;
	}
	public void setLockerId(long lockerId) {
		this.lockerId = lockerId;
	}
	public int getLockMinute() {
		return lockMinute;
	}
	public void setLockMinute(int lockMinute) {
		this.lockMinute = lockMinute;
	}
	public String getUnlockType() {
		return unlockType;
	}
	public void setUnlockType(String unlockType) {
		this.unlockType = unlockType;
	}
	public String getUnlockTime() {
		return unlockTime;
	}
	public void setUnlockTime(String unlockTime) {
		this.unlockTime = unlockTime;
	}
	public long getUnlockerId() {
		return unlockerId;
	}
	public void setUnlockerId(long unlockerId) {
		this.unlockerId = unlockerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIdcardCode() {
		return idcardCode;
	}
	public void setIdcardCode(String idcardCode) {
		this.idcardCode = idcardCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLockerName() {
		return lockerName;
	}
	public void setLockerName(String lockerName) {
		this.lockerName = lockerName;
	}
	public String getUnlockerName() {
		return unlockerName;
	}
	public void setUnlockerName(String unlockerName) {
		this.unlockerName = unlockerName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
