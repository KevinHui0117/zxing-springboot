package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="PasswordLockRule")
public class PasswordLockRule implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;		//主键
	private int errorMax;		//密码错误允许的最大次数
	private int lockTime;		//密码错误达到最大次数后账户被锁定的时间（单位：分钟）
	private int lockTimeType; //类型
	private int enable;     //是否启用

	private String dataCode;		//数据权限代码
	private String note;		//注释
	private long creater;		//创建人
	private String createName;		//创建人姓名
	private String createTime;		//创建时间
	private long updater;		//更新人
	private String updateName;		//更新人姓名
	private String updateTime;		//更新时间	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getErrorMax() {
		return errorMax;
	}
	public void setErrorMax(int errorMax) {
		this.errorMax = errorMax;
	}
	public int getLockTime() {
		return lockTime;
	}
	public void setLockTime(int lockTime) {
		this.lockTime = lockTime;
	}
	public int getLockTimeType() {
		return lockTimeType;
	}
	public void setLockTimeType(int lockTimeType) {
		this.lockTimeType = lockTimeType;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
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

	
	
}
