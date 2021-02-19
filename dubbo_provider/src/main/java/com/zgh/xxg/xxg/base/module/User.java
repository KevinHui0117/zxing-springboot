package com.zgh.xxg.xxg.base.module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class User extends BaseEntity implements Serializable{

	public static final String NORMAL_STATUS="1";
	public static final String DELETE_STATUS="0";
	public static final String LOCK_STATUS="3";
	
	
	private static final long serialVersionUID = 1L;

	private String fullName;		//姓名
	private String pinyin;			//拼音
	private String pinyinAbbr;		//拼音缩写
	
	private String idcardType;		//证件类型
	private String idcardCode;		//证件号码
	private String idcardStartDate;		//证件有效期开始日期
	private String idcardEndDate;		//证件有效期结束日期
	private String birthday;		//生日
	private String sex;			//性别
	
	private String userName;		//用户名
	private String mobile;		//手机号
	private String email;		//邮箱
	private String pwd;		//密码
	private String status;		//状态
	private String certificationLevel;		//实名认证级别
	private String groups;//所属群体--工会会员系统-入会申请时所需-数据字典

	private String ifMember;		//是否工会会员(职工类型，普通职工还是工会会员)：1普通职工，2工会会员
	private String userType;	//用户类型，用户属性（职工还是工作人员）
	private int passwordErrorNumber;		//密码错误次数
	private String lastLoginTime;		//最后一次登录时间
	
	
	private String mainInfoUpdateTime;		//主要信息更新时间
	
	//2020-07-31
	private String memberStatus;	//会员状态
		
	//以下信息不存数据库
	private UserBasic userBasic;
	private UserBusiness userBusiness;
	private UserOA userOa;
	
	private String companyName;		//所属单位名称（公司名称）
	private long companyId;		//所属单位Id
	private String companyStartTime;  //与单位关联的起始时间
	//对应单位信息
	private String nowProvinceCom;		//现居地-省,包括直辖市--单位
	private String nowCityCom;		//现居地-地市，--单位
	private String nowAreaCom;		//现居地-区，--单位
	private String nowStreetCom;     //现居地 - 街道--单位
	private String nowProvinceComShow;		//现居地-省,包括直辖市--单位显示
	private String nowCityComShow;		//现居地-地市，--单位显示
	private String nowAreaComShow;		//现居地-区，--单位显示
	private String nowStreetComShow;     //现居地 - 街道--单位显示
	
	private String labourUnionName;		//所属工会名称
	private long labourUnionId;		//所属工会ID
	private String labourUnionStartTime;  //与工会关联的起始时间
	

	
	
	private String businessCode; //本次登录的业务标识
	private String age;//年龄
	private String birthdayShow;//生日日期的显示

	//与组织的关联关系
	private List<UserAndOrganization> userAndOrganizations=new ArrayList<UserAndOrganization>();
	private List<UserAndOaOrganization> userAndOaOrganizations=new ArrayList<UserAndOaOrganization>();
	private List<UserAndCompany> userAndCompanys=new ArrayList<UserAndCompany>();
	private List<UserAndLabourUnion> userAndLabourUnions=new ArrayList<UserAndLabourUnion>();
	
	private String labourUnionUnifiedCode;		//工会统一社会信用代码-仅用户修改或详情时显示
	
	//用户担任分管领导的OA组织
	private List<OaLeader> leaderOaIds=new ArrayList<OaLeader>();
	//用户担任管理者的OA组织
	private List<OaManager> managerOaIds=new ArrayList<OaManager>();
	//认证级别类型显示
	private String certificationLevelName;


	
	public List<OaLeader> getLeaderOaIds() {
		return leaderOaIds;
	}
	public void setLeaderOaIds(List<OaLeader> leaderOaIds) {
		this.leaderOaIds = leaderOaIds;
	}
	public List<OaManager> getManagerOaIds() {
		return managerOaIds;
	}
	public void setManagerOaIds(List<OaManager> managerOaIds) {
		this.managerOaIds = managerOaIds;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getPinyinAbbr() {
		return pinyinAbbr;
	}
	public void setPinyinAbbr(String pinyinAbbr) {
		this.pinyinAbbr = pinyinAbbr;
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
	public String getIdcardStartDate() {
		return idcardStartDate;
	}
	public void setIdcardStartDate(String idcardStartDate) {
		this.idcardStartDate = idcardStartDate;
	}
	public String getIdcardEndDate() {
		return idcardEndDate;
	}
	public void setIdcardEndDate(String idcardEndDate) {
		this.idcardEndDate = idcardEndDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCertificationLevel() {
		return certificationLevel;
	}
	public void setCertificationLevel(String certificationLevel) {
		this.certificationLevel = certificationLevel;
	}
	public String getIfMember() {
		return ifMember;
	}
	public void setIfMember(String ifMember) {
		this.ifMember = ifMember;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}
	public UserBasic getUserBasic() {
		return userBasic;
	}
	public void setUserBasic(UserBasic userBasic) {
		this.userBasic = userBasic;
	}
	public UserBusiness getUserBusiness() {
		return userBusiness;
	}
	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
	public UserOA getUserOa() {
		return userOa;
	}
	public void setUserOa(UserOA userOa) {
		this.userOa = userOa;
	}
	public int getPasswordErrorNumber() {
		return passwordErrorNumber;
	}
	public void setPasswordErrorNumber(int passwordErrorNumber) {
		this.passwordErrorNumber = passwordErrorNumber;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public long getLabourUnionId() {
		return labourUnionId;
	}
	public void setLabourUnionId(long labourUnionId) {
		this.labourUnionId = labourUnionId;
	}
	public String getLabourUnionStartTime() {
		return labourUnionStartTime;
	}
	public void setLabourUnionStartTime(String labourUnionStartTime) {
		this.labourUnionStartTime = labourUnionStartTime;
	}
	public String getMainInfoUpdateTime() {
		return mainInfoUpdateTime;
	}
	public void setMainInfoUpdateTime(String mainInfoUpdateTime) {
		this.mainInfoUpdateTime = mainInfoUpdateTime;
	}
	public List<UserAndOrganization> getUserAndOrganizations() {
		return userAndOrganizations;
	}
	public void setUserAndOrganizations(
			List<UserAndOrganization> userAndOrganizations) {
		this.userAndOrganizations = userAndOrganizations;
	}
	public List<UserAndOaOrganization> getUserAndOaOrganizations() {
		return userAndOaOrganizations;
	}
	public void setUserAndOaOrganizations(
			List<UserAndOaOrganization> userAndOaOrganizations) {
		this.userAndOaOrganizations = userAndOaOrganizations;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}


	public String getLabourUnionUnifiedCode() {
		return labourUnionUnifiedCode;
	}

	public void setLabourUnionUnifiedCode(String labourUnionUnifiedCode) {
		this.labourUnionUnifiedCode = labourUnionUnifiedCode;
	}

	public String getCertificationLevelName() {
		return certificationLevelName;
	}

	public void setCertificationLevelName(String certificationLevelName) {
		this.certificationLevelName = certificationLevelName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public List<UserAndCompany> getUserAndCompanys() {
		return userAndCompanys;
	}
	public void setUserAndCompanys(List<UserAndCompany> userAndCompanys) {
		this.userAndCompanys = userAndCompanys;
	}
	public List<UserAndLabourUnion> getUserAndLabourUnions() {
		return userAndLabourUnions;
	}
	public void setUserAndLabourUnions(List<UserAndLabourUnion> userAndLabourUnions) {
		this.userAndLabourUnions = userAndLabourUnions;
	}
	public String getCompanyStartTime() {
		return companyStartTime;
	}
	public void setCompanyStartTime(String companyStartTime) {
		this.companyStartTime = companyStartTime;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getNowProvinceCom() {
		return nowProvinceCom;
	}

	public void setNowProvinceCom(String nowProvinceCom) {
		this.nowProvinceCom = nowProvinceCom;
	}

	public String getNowCityCom() {
		return nowCityCom;
	}

	public void setNowCityCom(String nowCityCom) {
		this.nowCityCom = nowCityCom;
	}

	public String getNowAreaCom() {
		return nowAreaCom;
	}

	public void setNowAreaCom(String nowAreaCom) {
		this.nowAreaCom = nowAreaCom;
	}

	public String getNowStreetCom() {
		return nowStreetCom;
	}

	public void setNowStreetCom(String nowStreetCom) {
		this.nowStreetCom = nowStreetCom;
	}

	public String getNowProvinceComShow() {
		return nowProvinceComShow;
	}

	public void setNowProvinceComShow(String nowProvinceComShow) {
		this.nowProvinceComShow = nowProvinceComShow;
	}

	public String getNowCityComShow() {
		return nowCityComShow;
	}

	public void setNowCityComShow(String nowCityComShow) {
		this.nowCityComShow = nowCityComShow;
	}

	public String getNowAreaComShow() {
		return nowAreaComShow;
	}

	public void setNowAreaComShow(String nowAreaComShow) {
		this.nowAreaComShow = nowAreaComShow;
	}

	public String getNowStreetComShow() {
		return nowStreetComShow;
	}

	public void setNowStreetComShow(String nowStreetComShow) {
		this.nowStreetComShow = nowStreetComShow;
	}

    public String getBirthdayShow() {
        return birthdayShow;
    }

    public void setBirthdayShow(String birthdayShow) {
        this.birthdayShow = birthdayShow;
    }
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
    
    
}
