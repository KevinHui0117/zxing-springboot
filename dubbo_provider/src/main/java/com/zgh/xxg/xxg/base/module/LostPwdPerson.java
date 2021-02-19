package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LostPwdPerson")
public class LostPwdPerson extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String COMMIT_STATUS="0";
	public static final String AUDIT_YES_STATUS="1";
	public static final String AUDIT_NO_STATUS="2";
	
	
	
	private long userId;		//用户ID
	private String reason;		//申诉理由
	private String fullName;		//真实原因
	private String idcardType;		//证件类型
	private String idcardCode;		//证件号码
	private String newMobile;		//新手机号码
	private String url1;		//证件正面照
	private String url2;		//证件背面照
	private String status;		//当前状态  0未审核，1已审核通过 ，2审核未通过
	private String auditInfo;	//审核信息，审核失败必填
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getNewMobile() {
		return newMobile;
	}
	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}
	public String getUrl1() {
		return url1;
	}
	public void setUrl1(String url1) {
		this.url1 = url1;
	}
	public String getUrl2() {
		return url2;
	}
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuditInfo() {
		return auditInfo;
	}
	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}
	
	
	
	
}
