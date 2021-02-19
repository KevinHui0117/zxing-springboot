package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LabourUnionCredit")
public class LabourUnionCredit extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long labourUnionId;	//用户ID
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
	private String labourUnionName;	//名称
	private String labourUnionType;	//工会类型
	private String labourUnionUnifiedCode;	//工会法人社会统一信用代码

	
	private String starterName;
	private String cancelerName;
	
	
	public long getLabourUnionId() {
		return labourUnionId;
	}
	public void setLabourUnionId(long labourUnionId) {
		this.labourUnionId = labourUnionId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}
	public String getLabourUnionType() {
		return labourUnionType;
	}
	public void setLabourUnionType(String labourUnionType) {
		this.labourUnionType = labourUnionType;
	}
	public String getLabourUnionUnifiedCode() {
		return labourUnionUnifiedCode;
	}
	public void setLabourUnionUnifiedCode(String labourUnionUnifiedCode) {
		this.labourUnionUnifiedCode = labourUnionUnifiedCode;
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
	
	
	
}
