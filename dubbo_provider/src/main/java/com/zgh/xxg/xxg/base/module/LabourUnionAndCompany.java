package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LabourUnionAndCompany")
public class LabourUnionAndCompany extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long labourUnionId;  //工会ID
	private long companyId;		//单位ID
	private String status;
	private String linkType;
	private String startTime;
	private String endTime;
	
	
	//以下信息不存数据库
	private String homeStarName;//职工之家星级
	private Integer poorNumber;//职工之家星级
	private String createLabourUnionTime;
	private String labourUnionName;
	private Long labourUnionParentId;
	private String labourUnionParentName;
	private String companyName;		//单位名称
	private String companyMean;		//单位属性
	private String companyUnifiedCode;		//单位统一社会信用代码
	private String companyCreateTime;		//成立日期
	private String companyLawPerson;		//单位法人代表
	private String companyLawPersonIdCardType;		//法人代表证件类型
	private String companyLawPersonIdCardCode;		//法人代表证件号码
	private String companyNature;		//单位性质类别
	private String companyIndustry;		//单位所属行业
	private String companyRegAddress;		//单位注册地址
	private String companyRealAddress;		//单位实际经营地址
	private String companyProvince;		//单位所在省
	private String companyCity;		//单位所在市
	private String companyArea;		//单位所在区
	private String companyStreet;		//单位所在镇街
	private String companyType;		//单位经济类型
	private String companyTel;		//单位联系电话
	private String companyPostcode;		//单位邮编
	private String partyStatus;		//党组织建立情况
	private String companyStatus;	//单位状态
	private String  companyProvinceShow;
	private String  companyCityShow;
	private String  companyAreaShow;
	private String  companyStreetShow;
	private String 	companyNatureName;
	private String 	companyIndustryName;
	private String 	companyTypeName;
	private String 	companyMeanName;
	private String  companyLawPersonIdCardTypeName;
	private String groups;//所属群体--工会会员系统-入会申请时所需-数据字典
	private String companyproperty; //单位属性
	private Integer memberNumber;
	private String termstarttime;
	private String termendtime;
	private String committeelistnum;
	private String reviewmannum;
	private String chairman;
	private String linkTel;
	private String homeStar;
	private String winInfo;
	private String localunion;

	public String getLocalunion() {		return this.localunion;	}
	public void setLocalunion(final String localunion) {	this.localunion = localunion;	}
	public String getTermstarttime() {		return this.termstarttime;	}
	public void setTermstarttime(final String termstarttime) {		this.termstarttime = termstarttime;	}
	public String getTermendtime() {		return this.termendtime;	}
	public void setTermendtime(final String termendtime) {		this.termendtime = termendtime;	}
	public String getCommitteelistnum() {		return this.committeelistnum;	}
	public void setCommitteelistnum(final String committeelistnum) {		this.committeelistnum = committeelistnum;	}
	public String getReviewmannum() {		return this.reviewmannum;	}
	public void setReviewmannum(final String reviewmannum) {		this.reviewmannum = reviewmannum;	}
	public String getChairman() {		return this.chairman;	}
	public void setChairman(final String chairman) {		this.chairman = chairman;	}
	public String getLinkTel() {		return this.linkTel;	}
	public void setLinkTel(final String linkTel) {		this.linkTel = linkTel;	}

	public String getHomeStar() {
		return this.homeStar;
	}

	public void setHomeStar(final String homeStar) {
		this.homeStar = homeStar;
	}

	public String getWinInfo() {
		return this.winInfo;
	}

	public void setWinInfo(final String winInfo) {
		this.winInfo = winInfo;
	}

	public Integer getMemberNumber() {	return this.memberNumber;	}
	public void setMemberNumber(final Integer memberNumber) {		this.memberNumber = memberNumber;	}

	public Integer getPoorNumber() {	return this.poorNumber;	}
	public void setPoorNumber(final Integer poorNumber) {		this.poorNumber = poorNumber;	}

	public String getHomeStarName() {		return this.homeStarName;	}
	public void setHomeStarName(final String homeStarName) {		this.homeStarName = homeStarName;	}
	public String getCreateLabourUnionTime() {		return this.createLabourUnionTime;	}
	public void setCreateLabourUnionTime(final String createLabourUnionTime) {		this.createLabourUnionTime = createLabourUnionTime;	}
	public String getCompanyproperty() {	return companyproperty;	}
	public void setCompanyproperty(String companyproperty) {		this.companyproperty = companyproperty;	}

	public Long getLabourUnionParentId() {		return this.labourUnionParentId;	}
	public void setLabourUnionParentId(final Long labourUnionParentId) {		this.labourUnionParentId = labourUnionParentId;	}
	public String getLabourUnionParentName() {		return this.labourUnionParentName;	}
	public void setLabourUnionParentName(final String labourUnionParentName) {		this.labourUnionParentName = labourUnionParentName;	}
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public long getLabourUnionId() {
		return labourUnionId;
	}

	public void setLabourUnionId(long labourUnionId) {
		this.labourUnionId = labourUnionId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUnifiedCode() {
		return companyUnifiedCode;
	}

	public void setCompanyUnifiedCode(String companyUnifiedCode) {
		this.companyUnifiedCode = companyUnifiedCode;
	}

	public String getCompanyLawPerson() {
		return companyLawPerson;
	}

	public void setCompanyLawPerson(String companyLawPerson) {
		this.companyLawPerson = companyLawPerson;
	}

	public String getCompanyLawPersonIdCardType() {
		return companyLawPersonIdCardType;
	}

	public void setCompanyLawPersonIdCardType(String companyLawPersonIdCardType) {
		this.companyLawPersonIdCardType = companyLawPersonIdCardType;
	}

	public String getCompanyLawPersonIdCardCode() {
		return companyLawPersonIdCardCode;
	}

	public void setCompanyLawPersonIdCardCode(String companyLawPersonIdCardCode) {
		this.companyLawPersonIdCardCode = companyLawPersonIdCardCode;
	}

	public String getCompanyNature() {
		return companyNature;
	}

	public void setCompanyNature(String companyNature) {
		this.companyNature = companyNature;
	}

	public String getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public String getCompanyRegAddress() {
		return companyRegAddress;
	}

	public void setCompanyRegAddress(String companyRegAddress) {
		this.companyRegAddress = companyRegAddress;
	}

	public String getCompanyRealAddress() {
		return companyRealAddress;
	}

	public void setCompanyRealAddress(String companyRealAddress) {
		this.companyRealAddress = companyRealAddress;
	}

	public String getCompanyProvince() {
		return companyProvince;
	}

	public void setCompanyProvince(String companyProvince) {
		this.companyProvince = companyProvince;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyPostcode() {
		return companyPostcode;
	}

	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
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

	public String getLabourUnionName() {
		return labourUnionName;
	}

	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyMean() {
		return companyMean;
	}

	public void setCompanyMean(String companyMean) {
		this.companyMean = companyMean;
	}

	public String getCompanyCreateTime() {
		return companyCreateTime;
	}

	public void setCompanyCreateTime(String companyCreateTime) {
		this.companyCreateTime = companyCreateTime;
	}

	public String getCompanyStreet() {
		return companyStreet;
	}

	public void setCompanyStreet(String companyStreet) {
		this.companyStreet = companyStreet;
	}

	public String getPartyStatus() {
		return partyStatus;
	}

	public void setPartyStatus(String partyStatus) {
		this.partyStatus = partyStatus;
	}

	public String getCompanyProvinceShow() {
		return companyProvinceShow;
	}

	public void setCompanyProvinceShow(String companyProvinceShow) {
		this.companyProvinceShow = companyProvinceShow;
	}

	public String getCompanyCityShow() {
		return companyCityShow;
	}

	public void setCompanyCityShow(String companyCityShow) {
		this.companyCityShow = companyCityShow;
	}

	public String getCompanyAreaShow() {
		return companyAreaShow;
	}

	public void setCompanyAreaShow(String companyAreaShow) {
		this.companyAreaShow = companyAreaShow;
	}

	public String getCompanyStreetShow() {
		return companyStreetShow;
	}

	public void setCompanyStreetShow(String companyStreetShow) {
		this.companyStreetShow = companyStreetShow;
	}

	public String getCompanyNatureName() {
		return companyNatureName;
	}

	public void setCompanyNatureName(String companyNatureName) {
		this.companyNatureName = companyNatureName;
	}

	public String getCompanyIndustryName() {
		return companyIndustryName;
	}

	public void setCompanyIndustryName(String companyIndustryName) {
		this.companyIndustryName = companyIndustryName;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	public String getCompanyMeanName() {
		return companyMeanName;
	}

	public void setCompanyMeanName(String companyMeanName) {
		this.companyMeanName = companyMeanName;
	}

	public String getCompanyLawPersonIdCardTypeName() {
		return companyLawPersonIdCardTypeName;
	}

	public void setCompanyLawPersonIdCardTypeName(
			String companyLawPersonIdCardTypeName) {
		this.companyLawPersonIdCardTypeName = companyLawPersonIdCardTypeName;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}
	
	
}
