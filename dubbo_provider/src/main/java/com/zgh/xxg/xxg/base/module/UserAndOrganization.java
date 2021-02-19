package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserAndOrganization")
public class UserAndOrganization extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private long userId;   //用户ID
	private long organizationId;	//组织ID
	private String status;		//状态
	private String linkType;	//关联类型
	private String startTime;	//开始时间
	private String endTime;		//结束时间
	private String inReason;	//进入原因
	private String outReason;		//离开原因
	
	//以下数据不存数据库
	private String  organizationName;
	private String fullName;
	private String mobile;

	private String ifMemberCard;  //是否有会员卡
	private String idcardType;  //身份证类型
	private String idcardCode;  //证件号码
	private String ifMember ;  //职工类型
	private String companyName ; //公司名称
	private String job;		//职务
	private String jobLevel;	//职称
	private String jobRank; //职级 --oa系统专有
	private String sex;    //性别
	private String certificationLevel;
	
	private String userStatus;
	private String organizationStatus;
	
	
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getOrganizationStatus() {
		return organizationStatus;
	}
	public void setOrganizationStatus(String organizationStatus) {
		this.organizationStatus = organizationStatus;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
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
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIfMemberCard() {
		return ifMemberCard;
	}

	public void setIfMemberCard(String ifMemberCard) {
		this.ifMemberCard = ifMemberCard;
	}

	public String getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIfMember() {
		return ifMember;
	}

	public void setIfMember(String ifMember) {
		this.ifMember = ifMember;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIdcardCode() {
		return idcardCode;
	}

	public void setIdcardCode(String idcardCode) {
		this.idcardCode = idcardCode;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobRank() {
		return jobRank;
	}

	public void setJobRank(String jobRank) {
		this.jobRank = jobRank;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCertificationLevel() {
		return certificationLevel;
	}
	public void setCertificationLevel(String certificationLevel) {
		this.certificationLevel = certificationLevel;
	}
	
}
