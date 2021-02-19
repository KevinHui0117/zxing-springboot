package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserAndLabourUnion")
public class UserAndLabourUnion extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private long userId;   //用户ID
	private long labourUnionId;	//工会ID
	private String status;		//状态
	private String linkType;	//关联类型
	private String startTime;	//开始时间
	private String endTime;		//结束时间
	private String inReason;	//进入原因
	private String outReason;		//离开原因
	

	
	//以下数据不存数据库
	private String labourUnionName;
	private String fullName;
	private String mobile;
	
	private String userStatus;
	private String labourUnionStatus;
	
	
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getLabourUnionStatus() {
		return labourUnionStatus;
	}
	public void setLabourUnionStatus(String labourUnionStatus) {
		this.labourUnionStatus = labourUnionStatus;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
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
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInReason() {
		return inReason;
	}
	public void setInReason(String inReason) {
		this.inReason = inReason;
	}
	public String getOutReason() {
		return outReason;
	}
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

}
