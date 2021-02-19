package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="Industry")
public class Industry extends BaseEntity implements Serializable,Comparable<Industry>{

	private static final long serialVersionUID = 1L;
	

	private String industryCode;	//行业分类编码
	private String industryName;	//行业分类名称
	private long parentId;		//上级分类ID
	private String status;		//状态
		
	
	//以下信息不存数据库
	private String parentName;	//上级名称
		
	
	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
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
	public int compareTo(Industry industry) {
		return this.industryCode.compareToIgnoreCase(industry.getIndustryCode());
	}
	
	
}
