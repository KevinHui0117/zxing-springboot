package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="OaManager")
public class OaManager extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long oaId;
	private long userId;
	private String status;
	private String linkType;

	private String startTime;
	private String endTime;

	//以下信息不存数据库
	private String oaName;
	private String fullName;
	
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public long getOaId() {
		return oaId;
	}
	public void setOaId(long oaId) {
		this.oaId = oaId;
	}
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
	public String getOaName() {
		return oaName;
	}
	public void setOaName(String oaName) {
		this.oaName = oaName;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}
