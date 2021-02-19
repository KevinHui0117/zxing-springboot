package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="PasswordLockInfo")
public class PasswordLockInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private long lockerId;  //用户ID或者工会法人ID
	private String  lockerType;  //工会会员，工作人员，工会法人
	private String  status;		//状态
	private String  lockTime;		//锁定时间
	private  String unlockType;		//解锁类型
	private String  unlockTime;		//解锁时间
	private long  unlockerId;		//解锁人ID
	
	private String dataCode;		//数据权限代码
	private String note;		//注释
	private long creater;		//创建人
	private String createName;		//创建人姓名
	private String createTime;		//创建时间
	private long updater;		//更新人
	private String updateName;		//更新人姓名
	private String updateTime;		//更新时间
	
	//以下信息不存数据库
	private String  name;		//名称或姓名
	private String  code;		//统一信用证件号码或身份证件号码
	private String mobile;		//手机号码
	private String  labourUnionType;		//工会类型
	private String unlockerName;	//解锁人姓名


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getLockerId() {
		return lockerId;
	}
	public void setLockerId(long lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
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
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getCreater() {
		return creater;
	}
	public void setCreater(long creater) {
		this.creater = creater;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public long getUpdater() {
		return updater;
	}
	public void setUpdater(long updater) {
		this.updater = updater;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLabourUnionType() {
		return labourUnionType;
	}
	public void setLabourUnionType(String labourUnionType) {
		this.labourUnionType = labourUnionType;
	}
	public String getUnlockerName() {
		return unlockerName;
	}
	public void setUnlockerName(String unlockerName) {
		this.unlockerName = unlockerName;
	}
	
	
}
