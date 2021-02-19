package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="CompanyType")
public class CompanyType extends BaseEntity implements Serializable,Comparable<CompanyType>{

	private static final long serialVersionUID = 1L;
	

	private String companyTypeCode;	//单位性质编码
	private String companyTypeName;	//单位性质名称
	private long parentId;		//上级单位
	private String status; 	//状态，是否启用
	
	
	
	//以下信息不存数据库
	private String parentName;	//上级名称
	
	
	public String getCompanyTypeCode() {
		return companyTypeCode;
	}
	public void setCompanyTypeCode(String companyTypeCode) {
		this.companyTypeCode = companyTypeCode;
	}
	public String getCompanyTypeName() {
		return companyTypeName;
	}
	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
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
	public int compareTo(CompanyType companyType) {
		return this.getCompanyTypeCode().compareToIgnoreCase(companyType.getCompanyTypeCode());
	}
	
	
}
