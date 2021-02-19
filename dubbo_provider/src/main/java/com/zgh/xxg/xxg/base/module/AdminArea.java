package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="AdminArea")
public class AdminArea extends  BaseEntity  implements Serializable,Comparable<AdminArea>{

	private static final long serialVersionUID = 1L;
	
	
	private String adminAreaCode;	//行政区划编码
	private String adminAreaName;	//行政区划名称
	private String adminAreaType;	//行政区划类型
	private int adminAreaLevel;	//行政区划级别
	private long parentId;		//上级分类ID
	private String status;		//状态
	
		
	
	
	//以下信息不存数据库
	private String parentName;	//上级名称
	
	
	
	public String getAdminAreaCode() {
		return adminAreaCode;
	}
	public void setAdminAreaCode(String adminAreaCode) {
		this.adminAreaCode = adminAreaCode;
	}
	public String getAdminAreaName() {
		return adminAreaName;
	}
	public void setAdminAreaName(String adminAreaName) {
		this.adminAreaName = adminAreaName;
	}
	public String getAdminAreaType() {
		return adminAreaType;
	}
	public void setAdminAreaType(String adminAreaType) {
		this.adminAreaType = adminAreaType;
	}
	public int getAdminAreaLevel() {
		return adminAreaLevel;
	}
	public void setAdminAreaLevel(int adminAreaLevel) {
		this.adminAreaLevel = adminAreaLevel;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	@Override
	public int compareTo(AdminArea adminArea) {
		return this.getAdminAreaCode().compareToIgnoreCase(adminArea.getAdminAreaCode());
	}
	
	
	
	
	
}
