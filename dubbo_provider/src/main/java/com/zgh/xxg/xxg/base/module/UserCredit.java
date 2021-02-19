package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserCredit")
public class UserCredit extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long userId;	//用户ID
	private String creditType;		//征信类型
	private String regTime;			//登记时间
	
	private String endTime;		//失效时间

	private String source;		//数据来源
	private String status;		//状态
	private String description;  //违规描述
	
	private long starter;		//生效人
	private String startTime;		//生效时间
	
	private long canceler;		//撤销人
	private String cancelTime;		//撤销时间
	private String cancelReason;		//撤销原因
	
	//以下数据不存数据库
	private String fullName;	//姓名
	private String userType;	//用户类型
	private String idcardType;	//证件类型
	private String idcardCode;	//证件号码
	
	private String starterName;
	private String cancelerName;
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getStarter() {
		return starter;
	}
	public void setStarter(long starter) {
		this.starter = starter;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public long getCanceler() {
		return canceler;
	}
	public void setCanceler(long canceler) {
		this.canceler = canceler;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getStarterName() {
		return starterName;
	}
	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}
	public String getCancelerName() {
		return cancelerName;
	}
	public void setCancelerName(String cancelerName) {
		this.cancelerName = cancelerName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getIdcardType() {
		return idcardType;
	}
	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}
	public String getIdcardCode() {
		return idcardCode;
	}
	public void setIdcardCode(String idcardCode) {
		this.idcardCode = idcardCode;
	}
	
	
}
