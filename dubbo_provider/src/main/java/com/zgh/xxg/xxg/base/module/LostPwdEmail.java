package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LostPwdEmail")
public class LostPwdEmail extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String COMMIT_STATUS="0";
	public static final String AUDIT_YES_STATUS="1";
	public static final String AUDIT_NO_STATUS="2";
	
	
	
	private long userId;		//用户ID
	private String emailSign;   //邮件签名
	private String status;		//当前状态  0未审核，1已审核通过 ，2审核未通过
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmailSign() {
		return emailSign;
	}
	public void setEmailSign(String emailSign) {
		this.emailSign = emailSign;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
}
