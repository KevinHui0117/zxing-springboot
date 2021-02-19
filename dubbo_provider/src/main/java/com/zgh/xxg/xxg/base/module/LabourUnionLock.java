package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LabourUnionLock")
public class LabourUnionLock extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String LOCK_TYPE_PASSWORD="1";
	public static final String STATUS_LOCK="1";
	public static final String STATUS_UNLOCK="0";
	public static final String UNLOCK_AUTO="1";
	public static final String UNLOCK_HAND="2";
	
	

	private long labourUnionId;  	//用户ID
	private long userId;		//导致该工会被锁定的人员
	private String  status;			//状态
	private String  lockTime;		//锁定时间
	private String lockType;		// 锁定类型
	private long lockerId;			//锁定人
	private int lockMinute;		//锁定时长 -1表示长期锁定
	private  String unlockType;		//解锁类型
	private String  unlockTime;		//解锁时间
	private long  unlockerId;		//解锁人ID
	
	
	
	//以下信息不存数据库
	private String  labourUnionUnifiedCode;	//工会法人社会信用代码
	private String  labourUnionName;		//工会名称
	private String fullName;		//导致该工会被锁定的人员姓名
	private String mobile;		//导致该工会被锁定的人员手机
	private String labourUnionType; 	//工会类型
	private String lockerName;		//锁定人姓名
	private String unlockerName;	//解锁人姓名
	
	public long getLabourUnionId() {
		return labourUnionId;
	}
	public void setLabourUnionId(long labourUnionId) {
		this.labourUnionId = labourUnionId;
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
	
	public String getLabourUnionUnifiedCode() {
		return labourUnionUnifiedCode;
	}
	public void setLabourUnionUnifiedCode(String labourUnionUnifiedCode) {
		this.labourUnionUnifiedCode = labourUnionUnifiedCode;
	}
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
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
	public String getLabourUnionType() {
		return labourUnionType;
	}
	public void setLabourUnionType(String labourUnionType) {
		this.labourUnionType = labourUnionType;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
