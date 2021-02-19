package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="OrganizationLabourUnion")
public class OrganizationLabourUnion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;		//主键
	private long organizationId;		//组织唯一标识
	private String labourUnionType;		//工会类型
	private String labourUnionStatus;		//工会状态
	private String createLabourUnionTime; 		//建会时间
	private String linkMan;		//联系人
	private String linkTel;		//联系电话
	private String linkEmail;  //联系邮箱
	private String chairman;			//工会主席
	private String chairmanTel;  //主席电话
	private String chairmanStartTime;
	private String chairmanEndTime;
	private String ifServiceStation;
	
	private String ifCreateFeeCheck; 	//是否建立经费审查委员会
	private String feeCheckChairman;		//经审会主席
	private String feeCheckTel;			//经审会联系电话
	
	private String ifCreateWomen;		//是否建立女职工委员会
	private String womenChairman;		//女工委主任
	private String womenTel;			//女工委联系电话
	
	private String ifCreateStaff;		//是否创建职工代表大会制度
	private String ifCreateOpen;		//是否创建厂务公开制度
	private String ifCreateContract;		//是否建立集体合同制度
	
	private String ifJoinCare;		//是否参与市总职工医疗互助保障
	private int joinCareNumber;		//参与市总职工医疗互助保障的人数
	private String ifCreateMemberCard;		//是否办理工会会员卡
	private int memberCardNumber;		//办理工会会员卡的人数
	
	
	private String companyName;		//单位名称
	private String companyUnifiedCode;		//单位统一社会信用代码
	private String companyLawPerson;		//单位法人代表
	private String companyLawPersonIdCardType;		//法人代表证件类型
	private String companyLawPersonIdCardCode;		//法人代表证件号码
	private String companyNature;		//单位性质类别
	private String companyIndustry;		//单位所属行业
	private String companyAddress;		//单位地址
	private String companyProvince;		//单位所在省
	private String companyCity;		//单位所在市
	private String companyArea;		//单位所在区
	private String companyType;		//单位经济类型
	private String companyTel;		//单位联系电话
	private String companyPostcode;		//单位邮编
	

	private String dataCode;		//数据权限代码
	private String note;		//注释
	private long creater;		//创建人
	private String createName;		//创建人姓名
	private String createTime;		//创建时间
	private long updater;		//更新人
	private String updateName;		//更新人姓名
	private String updateTime;		//更新时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	
	public String getLabourUnionType() {
		return labourUnionType;
	}
	public void setLabourUnionType(String labourUnionType) {
		this.labourUnionType = labourUnionType;
	}
	public String getLabourUnionStatus() {
		return labourUnionStatus;
	}
	public void setLabourUnionStatus(String labourUnionStatus) {
		this.labourUnionStatus = labourUnionStatus;
	}
	public String getCreateLabourUnionTime() {
		return createLabourUnionTime;
	}
	public void setCreateLabourUnionTime(String createLabourUnionTime) {
		this.createLabourUnionTime = createLabourUnionTime;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getLinkEmail() {
		return linkEmail;
	}
	public void setLinkEmail(String linkEmail) {
		this.linkEmail = linkEmail;
	}
	public String getChairman() {
		return chairman;
	}
	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
	public String getChairmanTel() {
		return chairmanTel;
	}
	public void setChairmanTel(String chairmanTel) {
		this.chairmanTel = chairmanTel;
	}
	public String getChairmanStartTime() {
		return chairmanStartTime;
	}
	public void setChairmanStartTime(String chairmanStartTime) {
		this.chairmanStartTime = chairmanStartTime;
	}
	public String getChairmanEndTime() {
		return chairmanEndTime;
	}
	public void setChairmanEndTime(String chairmanEndTime) {
		this.chairmanEndTime = chairmanEndTime;
	}
	public String getIfServiceStation() {
		return ifServiceStation;
	}
	public void setIfServiceStation(String ifServiceStation) {
		this.ifServiceStation = ifServiceStation;
	}
	public String getIfCreateFeeCheck() {
		return ifCreateFeeCheck;
	}
	public void setIfCreateFeeCheck(String ifCreateFeeCheck) {
		this.ifCreateFeeCheck = ifCreateFeeCheck;
	}
	public String getFeeCheckChairman() {
		return feeCheckChairman;
	}
	public void setFeeCheckChairman(String feeCheckChairman) {
		this.feeCheckChairman = feeCheckChairman;
	}
	public String getFeeCheckTel() {
		return feeCheckTel;
	}
	public void setFeeCheckTel(String feeCheckTel) {
		this.feeCheckTel = feeCheckTel;
	}
	public String getIfCreateWomen() {
		return ifCreateWomen;
	}
	public void setIfCreateWomen(String ifCreateWomen) {
		this.ifCreateWomen = ifCreateWomen;
	}
	public String getWomenChairman() {
		return womenChairman;
	}
	public void setWomenChairman(String womenChairman) {
		this.womenChairman = womenChairman;
	}
	public String getWomenTel() {
		return womenTel;
	}
	public void setWomenTel(String womenTel) {
		this.womenTel = womenTel;
	}
	public String getIfCreateStaff() {
		return ifCreateStaff;
	}
	public void setIfCreateStaff(String ifCreateStaff) {
		this.ifCreateStaff = ifCreateStaff;
	}
	public String getIfCreateOpen() {
		return ifCreateOpen;
	}
	public void setIfCreateOpen(String ifCreateOpen) {
		this.ifCreateOpen = ifCreateOpen;
	}
	public String getIfCreateContract() {
		return ifCreateContract;
	}
	public void setIfCreateContract(String ifCreateContract) {
		this.ifCreateContract = ifCreateContract;
	}
	public String getIfJoinCare() {
		return ifJoinCare;
	}
	public void setIfJoinCare(String ifJoinCare) {
		this.ifJoinCare = ifJoinCare;
	}
	public int getJoinCareNumber() {
		return joinCareNumber;
	}
	public void setJoinCareNumber(int joinCareNumber) {
		this.joinCareNumber = joinCareNumber;
	}
	public String getIfCreateMemberCard() {
		return ifCreateMemberCard;
	}
	public void setIfCreateMemberCard(String ifCreateMemberCard) {
		this.ifCreateMemberCard = ifCreateMemberCard;
	}
	public int getMemberCardNumber() {
		return memberCardNumber;
	}
	public void setMemberCardNumber(int memberCardNumber) {
		this.memberCardNumber = memberCardNumber;
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
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getCreater() {
		return creater;
	}
	public void setCreater(long creater) {
		this.creater = creater;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public long getUpdater() {
		return updater;
	}
	public void setUpdater(long updater) {
		this.updater = updater;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
