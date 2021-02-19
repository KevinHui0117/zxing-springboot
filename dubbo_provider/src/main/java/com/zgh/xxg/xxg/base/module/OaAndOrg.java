package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="OaAndOrg")
public class OaAndOrg extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long oaId;
	private long orgId;
	private String status;
	private String startTime;
	private String endTime;
	//以下信息不存数据库
	private String oaName;
	private String orgName;
	public long getOaId() {
		return oaId;
	}
	public void setOaId(long oaId) {
		this.oaId = oaId;
	}
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
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
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	
}
