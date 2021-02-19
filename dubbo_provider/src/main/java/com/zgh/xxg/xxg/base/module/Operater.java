package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 操作者信息，包括操作标识，操作者编号，操作者姓名，操作系统，操作IP, 操作时间，操作使用的随机数和操作令牌,操作使用的参数
 */
@Alias(value = "Operater")
public class Operater  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String businessCode;		//本次登录的唯一标识
	private long userId;		//操作者标识
	private String fullName;	//操作者姓名
	private String userName;	//操作者姓名
	private String ip;			//操作者所在IP
	private String orgType;		//操作者所在部门的类型 business或者oa
	private String userDataCode;	//操作者自己所在组织的代码，仅记录操作日志用
	private String mobile;
	private String email;
	private String idcardCode;
	private String idcardType;
	private String sex;
	private String certificationLevel;		//实名认证级别
	private String noPwd;  //没有密码，需要设置密码
	private String note;
	private String userType;	//用户类型，用户属性（1职工还是2工作人员）
	
	//用户关联的业务部门
	private String organizationIds;
	//用户关联的业务主部门
	private long masterOrganizationId;
	//用户关联的OA部门
	private String  oaOrganizationIds;
	//用户关联的OA主部门
	private long masterOaOrganizationId;

	private long orgId;  //操作者所在部门的Id
	//增加以下属性
	private String orgName;		//操作者所在部门名称 
	private long bigOrgId; //操作者所在单位ID
	private String bigOrgName; //操作者所在单位名称
	
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getMasterOrganizationId() {
		return masterOrganizationId;
	}
	public void setMasterOrganizationId(long masterOrganizationId) {
		this.masterOrganizationId = masterOrganizationId;
	}
	
	public long getMasterOaOrganizationId() {
		return masterOaOrganizationId;
	}
	public void setMasterOaOrganizationId(long masterOaOrganizationId) {
		this.masterOaOrganizationId = masterOaOrganizationId;
	}
	public String getOrganizationIds() {
		return organizationIds;
	}
	public void setOrganizationIds(String organizationIds) {
		this.organizationIds = organizationIds;
	}
	public String getOaOrganizationIds() {
		return oaOrganizationIds;
	}
	public void setOaOrganizationIds(String oaOrganizationIds) {
		this.oaOrganizationIds = oaOrganizationIds;
	}
	public String getNoPwd() {
		return noPwd;
	}
	public void setNoPwd(String noPwd) {
		this.noPwd = noPwd;
	}
	public String getCertificationLevel() {
		return certificationLevel;
	}
	public void setCertificationLevel(String certificationLevel) {
		this.certificationLevel = certificationLevel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserDataCode() {
		return userDataCode;
	}
	public void setUserDataCode(String userDataCode) {
		this.userDataCode = userDataCode;
	}
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdcardCode() {
		return idcardCode;
	}
	public void setIdcardCode(String idcardCode) {
		this.idcardCode = idcardCode;
	}
	public String getIdcardType() {
		return idcardType;
	}
	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	private  static Operater operater=new Operater();
	static{
		operater.setUserId(1L);
		operater.setFullName("系统");
	}
	
	public static Operater getSystemOperater(){
		return operater;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public long getBigOrgId() {
		return bigOrgId;
	}
	public void setBigOrgId(long bigOrgId) {
		this.bigOrgId = bigOrgId;
	}
	public String getBigOrgName() {
		return bigOrgName;
	}
	public void setBigOrgName(String bigOrgName) {
		this.bigOrgName = bigOrgName;
	}
}
