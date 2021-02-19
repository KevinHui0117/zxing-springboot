package com.zgh.xxg.xxg.base.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Alias(value="LabourUnion")
@ApiModel(description = "工会信息")
public class LabourUnion extends BaseEntity implements Serializable{

	public static final String NORMAL_STATUS="1";
	public static final String DELETE_STATUS="0";
	public static final String LOCK_STATUS="3";
	public static final String PREPARE_STATUS="4";//筹备期
	//工会类型
	public static  final String LABOURUNION_TYPE_BLU = "1";//基层工会
	public static  final String LABOURUNION_TYPE_LOCAL = "2";//地方工会，
	public static  final String LABOURUNION_TYPE_LOCAL_INDUSTRY = "3";//地方产业工会

	//工会组织类型
	public static  final String LABOURUNION_ORG_TYPE_SINGLE = "1";//独立基层工会
	public static  final String LABOURUNION_ORG_TYPE_COMBINED = "2";//联合基层工会
	public static  final String LABOURUNION_ORG_TYPE_STREET = "3";//街道工会
	public static  final String LABOURUNION_ORG_TYPE_ZONE = "4";//园区工会
	public static  final String LABOURUNION_ORG_TYPE_INDUSTRY = "5";//行业工会
	public static  final String LABOURUNION_ORG_TYPE_GROUP = "6";// 集团工会
	public static  final String LABOURUNION_ORG_TYPE_SYSTEM = "7";//系统工会
	public static  final String LABOURUNION_ORG_TYPE_BRANCH_TEAM = "8";//分会/小组



	//工会组织形式 1总工会、2工会、3工会联合会、4工会委员会、5联合工会委员会、6分会、7小组
	public static final String LABOURUNIONORGFORM_ZGH="1";
	public static final String LABOURUNIONORGFORM_GH="2";
	public static final String LABOURUNIONORGFORM_GHLHH="3";
	public static final String LABOURUNIONORGFORM_GHWYH="4";
	public static final String LABOURUNIONORGFORM_LHGHWYH="5";
	public static final String LABOURUNIONORGFORM_FENHUI="6";
	public static final String LABOURUNIONORGFORM_XIAOZU="7";

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="工会编码（自动生成）")
	private String labourUnionCode;
	@ApiModelProperty(value = "工作名称")
	private String labourUnionName;
	@ApiModelProperty(value = "密码，只有工会法人才拥有")
	private String pwd;
	@ApiModelProperty(value = "密码连续错误次数，只有工会法人才拥有")
	private int passwordErrorNumber;
	@ApiModelProperty(value = "最后登录时间，只有工会法人才拥有")
	private String lastLoginTime;
	@ApiModelProperty(value = "拼音")
	private String pinyin;
	@ApiModelProperty(value = "拼音缩写")
	private String pinyinAbbr;
	@ApiModelProperty(value = "建会方式  选项值为：线下建会1、网上建会2。默认值为线下建会。")
	private String  createlabouruniontype;
	@ApiModelProperty(value = "筹备组成立日期")
	private String  createpreparetime;//筹备组成立日期

	@ApiModelProperty(value = "职工总数")
	private int employeeNumber;
	@ApiModelProperty(value = "女职工总数")
	private int womanEmployeeNumber;
	@ApiModelProperty(value = "会员总数")
	private int memberNumber;
	@ApiModelProperty(value = "女会员总数")
	private int womanMemberNumber;
	@ApiModelProperty(value = "专职工会工作人员数量")
	private int cadreNumber;
	@ApiModelProperty(value = "兼职工会工作人员数量")
	private int  otherCadreNumber;
	@ApiModelProperty(value = "农民工职工数")
	private int farmerNumber;
	@ApiModelProperty(value = "困难职工数")
	private int poorNumber;
	@ApiModelProperty(value = "劳模数")
	private int modelNumber;

	@ApiModelProperty(value = "工会社会信用代码")
	private String labourUnionUnifiedCode;
	@ApiModelProperty(value = "工会类型，在公共基础数据的数据字典里面配置的，目前配置1基层工会，2地方工会，早期是1基层以上工会、2工会、3工会委员会、4联合工会")
	private String labourUnionType;
	@ApiModelProperty(value = "工会状态")
	private String labourUnionStatus;
	@ApiModelProperty(value = "建会时间")
	private String createLabourUnionTime; 
	@ApiModelProperty(value = "联系人")
	private String linkMan;
	@ApiModelProperty(value = "联系电话")
	private String linkTel;
	@ApiModelProperty(value = "联系邮箱")
	private String linkEmail;  
	@ApiModelProperty(value = "工会住所")
	private String linkAddress;
	@ApiModelProperty(value = "工会法人代表")
	private String labourUnionLawPerson;	
	@ApiModelProperty(value = "工会法人有效期限起")
	private String  labourUnionStartTime;	
	@ApiModelProperty(value = "工会法人有效期限止")
	private String  labourUnionEndTime;

	@ApiModelProperty(value = "工会主席")
	private String chairman;
	@ApiModelProperty(value = "工会主席联系电话")
	private String chairmanTel;
	@ApiModelProperty(value = "工会主席邮箱")
	private String chairmanEmail;
	@ApiModelProperty(value = "工会主席任期开始时间")
	private String chairmanStartTime;
	@ApiModelProperty(value = "工会主席任期结束时间")
	private String chairmanEndTime;
	@ApiModelProperty(value = "是否工会服务站")
	private String ifServiceStation;

	@ApiModelProperty(value = "是否有公章")
	private String ifCreateSeal;
	@ApiModelProperty(value = "是否开设银行对公账户")
	private String ifCreateBank;
	@ApiModelProperty(value = "银行账户")
	private String bankCode;

	@ApiModelProperty(value = "是否建立经费审查委员会")
	private String ifCreateFeeCheck;
	@ApiModelProperty(value = "经审会联系电话")
	private String feeCheckTel;
	@ApiModelProperty(value = "经审会主席")
	private String feeCheckChairman;
	@ApiModelProperty(value = "经审会委员")
	private String feeCheckMembers;

	@ApiModelProperty(value = "是否建立女职工委员会")
	private String ifCreateWomen;
	@ApiModelProperty(value = "女工委主任")
	private String womenChairman;
	@ApiModelProperty(value = "女工委委员")
	private String womenMembers;
	@ApiModelProperty(value = "女工委联系电话")
	private String womenTel;

	@ApiModelProperty(value = "是否创建职工代表大会制度")
	private String ifCreateStaff;
	@ApiModelProperty(value = "代表大会委员")
	private String staffMembers;

	@ApiModelProperty(value = "是否建立工会劳动法律监督委员会")
	private String ifCreateLabourLaw;
	@ApiModelProperty(value = "劳动法律监督委员会委员")
	private String labourLawMembers;

	@ApiModelProperty(value = "是否创建厂务公开制度")
	private String ifCreateOpen;
	@ApiModelProperty(value = "是否建立集体合同制度")
	private String ifCreateContract;

	@ApiModelProperty(value = "是否参与市总职工医疗互助保障")
	private String ifJoinCare;
	@ApiModelProperty(value = "参与市总职工医疗互助保障的人数")
	private int joinCareNumber;
	@ApiModelProperty(value = "是否办理工会会员卡")
	private String ifCreateMemberCard;
	@ApiModelProperty(value="办理工会会员卡的人数")
	private int memberCardNumber;

	@ApiModelProperty(value="职工之家星级")
	private String homeStar;
	@ApiModelProperty(value="获奖情况")
	private String winInfo;



	@ApiModelProperty(value="主要信息更新时间戳")
	private String mainInfoUpdateTime;
	
	
	//2020-06-24增加属性
	@ApiModelProperty(value="所属行政区划信息-省")
	private String labourUnionProvince;
	@ApiModelProperty(value="所属行政区划信息-市")
	private String labourUnionCity;
	@ApiModelProperty(value="所属行政区划信息-区")
	private String labourUnionArea;
	@ApiModelProperty(value="所属行政区划信息-街道")
	private String labourUnionStreet;
	@ApiModelProperty(value="工会所属行业")
	private String labourUnionIndustry;
	@ApiModelProperty(value="工会的单位性质类别")
	private String labourUnionNature;
	@ApiModelProperty(value="注销")
	private String logout;		//注销
	@ApiModelProperty(value="工会组织类型")
	private String labourunionorgtype;	//工会组织类型 // 1独立基层工会 2联合基层工会 3街道工会 4园区工会 5行业工会 6集团工会 7系统工会 8分会/小组
	@ApiModelProperty(value="工会组织形式")
	private String labourunionorgform;	//工会组织形式 // 1总工会、2工会、3工会联合会、4工会委员会、5联合工会委员会、6分会、7小组
	//2020-07-16 增加工会层级属性
	private String labourUnionLevel;   //工会层级  10 国家   20 省 21部级 22行业级  30市   40区  41 区产业级    50街镇   60社区  61社区下属灵活就业联合工会
	public static final  String LEVEL_TOP="10";
	public static final  String LEVEL_PROVINCE="20";
	public static final  String LEVEL_MINISTRY="21";
	public static final  String LEVEL_MINISTRY_INDUSTRY="22";
	public static final  String LEVEL_CITY="30";
	public static final  String LEVEL_AREA="40";
	public static final  String LEVEL_AREA_INDUSTRY="41";
	public static final  String LEVEL_STREET="50";
	public static final  String LEVEL_COMMUNITY="60";
	public static final  String LEVEL_COMMUNITY_AGILE="61";
	
		
	//以下信息不存数据库
	@ApiModelProperty(value="上级单位的ID")
	private long parentId;
	@ApiModelProperty(value="上级单位的名称")
	private String parentName;
	@ApiModelProperty(value="工会对应的企业")
	private List<LabourUnionAndCompany> companys=new ArrayList<LabourUnionAndCompany>();

	@ApiModelProperty(value="仅为展现下级工会使用 -- 公司名称")
	private  String companyNames;
	@ApiModelProperty(value="仅为展现下级工会使用 --统一社会信用代码")
	private String companyUnifiedCodes;
	@ApiModelProperty(value="所属区/地方工会")
	private String localUnion;
	@ApiModelProperty(value="建会批复文号")
	private String  createunionreplyno;//建会批复文号
	@ApiModelProperty(value="覆盖建会")
	private String  cover;//覆盖建会
	@ApiModelProperty(value = "负责人")
	private String  responsibleman;
	@ApiModelProperty(value = "负责人联系电话")
	private String  responsiblephone;
	@ApiModelProperty(value = "负责人电子邮箱")
	private String  responsibleemail;
	@ApiModelProperty(value = "负责人id")
	private String  responsiblemanid;//负责人id
	@ApiModelProperty(value="联系人id")
	private String  linkmanid;// 联系人id
	@ApiModelProperty(value = "工会地址")
	private String  labourunionaddress;//
	@ApiModelProperty(value="工会邮政编码")
	private String  labourunionpostcode;//

	
	
	private String businessCode; //本次登录的业务标识
	
	
	
	public String getLabourunionaddress() {		return labourunionaddress;	}
	public void setLabourunionaddress(String labourunionaddress) {		this.labourunionaddress = labourunionaddress;	}
	public String getLabourunionpostcode() {		return labourunionpostcode;	}
	public void setLabourunionpostcode(String labourunionpostcode) {		this.labourunionpostcode = labourunionpostcode;	}
	public String getLinkmanid() {	return linkmanid;}
	public void setLinkmanid(String linkmanid) {		this.linkmanid = linkmanid;	}
	public String getResponsiblemanid() {		return responsiblemanid;	}
	public void setResponsiblemanid(String responsiblemanid) {		this.responsiblemanid = responsiblemanid;	}
	public String getResponsibleman() {		return responsibleman;	}
	public void setResponsibleman(String responsibleman) {		this.responsibleman = responsibleman;	}
	public String getResponsiblephone() {		return responsiblephone;	}
	public void setResponsiblephone(String responsiblephone) {		this.responsiblephone = responsiblephone;	}
	public String getResponsibleemail() {		return responsibleemail;	}
	public void setResponsibleemail(String responsibleemail) {		this.responsibleemail = responsibleemail;	}
	public String getCover() {		return cover;	}
	public void setCover(String cover) {		this.cover = cover;	}
	public String getCreatepreparetime() {		return createpreparetime;	}
	public void setCreatepreparetime(String createpreparetime) {		this.createpreparetime = createpreparetime;	}

	public String getCreateunionreplyno() {		return createunionreplyno;	}
	public void setCreateunionreplyno(String createunionreplyno) {		this.createunionreplyno = createunionreplyno;	}
	public String getCreatelabouruniontype() {		return createlabouruniontype;	}
	public void setCreatelabouruniontype(String createlabouruniontype) {		this.createlabouruniontype = createlabouruniontype;	}

	public String getLocalUnion() {		return localUnion;	}
	public void setLocalUnion(String localUnion) {		this.localUnion = localUnion;	}
	public String getLabourunionorgform() {		return labourunionorgform;	}
	public void setLabourunionorgform(String labourunionorgform) {		this.labourunionorgform = labourunionorgform;	}
	public String getLabourunionorgtype() {		return labourunionorgtype;	}
	public void setLabourunionorgtype(String labourunionorgtype) {		this.labourunionorgtype = labourunionorgtype;	}
	public String getLogout() {		return logout;	}
	public void setLogout(String logout) {		this.logout = logout;	}
	public List<LabourUnionAndCompany> getCompanys() {
		return companys;
	}
	public void setCompanys(List<LabourUnionAndCompany> companys) {
		this.companys = companys;
	}
	public String getLabourUnionCode() {
		return labourUnionCode;
	}
	public void setLabourUnionCode(String labourUnionCode) {
		this.labourUnionCode = labourUnionCode;
	}
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public int getWomanEmployeeNumber() {
		return womanEmployeeNumber;
	}
	public void setWomanEmployeeNumber(int womanEmployeeNumber) {
		this.womanEmployeeNumber = womanEmployeeNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getWomanMemberNumber() {
		return womanMemberNumber;
	}
	public void setWomanMemberNumber(int womanMemberNumber) {
		this.womanMemberNumber = womanMemberNumber;
	}
	public int getCadreNumber() {
		return cadreNumber;
	}
	public void setCadreNumber(int cadreNumber) {
		this.cadreNumber = cadreNumber;
	}
	public int getOtherCadreNumber() {
		return otherCadreNumber;
	}
	public void setOtherCadreNumber(int otherCadreNumber) {
		this.otherCadreNumber = otherCadreNumber;
	}
	public int getFarmerNumber() {
		return farmerNumber;
	}
	public void setFarmerNumber(int farmerNumber) {
		this.farmerNumber = farmerNumber;
	}
	public int getPoorNumber() {
		return poorNumber;
	}
	public void setPoorNumber(int poorNumber) {
		this.poorNumber = poorNumber;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getLabourUnionUnifiedCode() {
		return labourUnionUnifiedCode;
	}
	public void setLabourUnionUnifiedCode(String labourUnionUnifiedCode) {
		this.labourUnionUnifiedCode = labourUnionUnifiedCode;
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
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getLabourUnionLawPerson() {
		return labourUnionLawPerson;
	}
	public void setLabourUnionLawPerson(String labourUnionLawPerson) {
		this.labourUnionLawPerson = labourUnionLawPerson;
	}
	public String getLabourUnionStartTime() {
		return labourUnionStartTime;
	}
	public void setLabourUnionStartTime(String labourUnionStartTime) {
		this.labourUnionStartTime = labourUnionStartTime;
	}
	public String getLabourUnionEndTime() {
		return labourUnionEndTime;
	}
	public void setLabourUnionEndTime(String labourUnionEndTime) {
		this.labourUnionEndTime = labourUnionEndTime;
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
	public String getChairmanEmail() {
		return chairmanEmail;
	}
	public void setChairmanEmail(String chairmanEmail) {
		this.chairmanEmail = chairmanEmail;
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
	public String getIfCreateSeal() {
		return ifCreateSeal;
	}
	public void setIfCreateSeal(String ifCreateSeal) {
		this.ifCreateSeal = ifCreateSeal;
	}
	public String getIfCreateBank() {
		return ifCreateBank;
	}
	public void setIfCreateBank(String ifCreateBank) {
		this.ifCreateBank = ifCreateBank;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getIfCreateFeeCheck() {
		return ifCreateFeeCheck;
	}
	public void setIfCreateFeeCheck(String ifCreateFeeCheck) {
		this.ifCreateFeeCheck = ifCreateFeeCheck;
	}
	public String getFeeCheckTel() {
		return feeCheckTel;
	}
	public void setFeeCheckTel(String feeCheckTel) {
		this.feeCheckTel = feeCheckTel;
	}
	public String getFeeCheckChairman() {
		return feeCheckChairman;
	}
	public void setFeeCheckChairman(String feeCheckChairman) {
		this.feeCheckChairman = feeCheckChairman;
	}
	public String getFeeCheckMembers() {
		return feeCheckMembers;
	}
	public void setFeeCheckMembers(String feeCheckMembers) {
		this.feeCheckMembers = feeCheckMembers;
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
	public String getWomenMembers() {
		return womenMembers;
	}
	public void setWomenMembers(String womenMembers) {
		this.womenMembers = womenMembers;
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
	public String getStaffMembers() {
		return staffMembers;
	}
	public void setStaffMembers(String staffMembers) {
		this.staffMembers = staffMembers;
	}
	public String getIfCreateLabourLaw() {
		return ifCreateLabourLaw;
	}
	public void setIfCreateLabourLaw(String ifCreateLabourLaw) {
		this.ifCreateLabourLaw = ifCreateLabourLaw;
	}
	public String getLabourLawMembers() {
		return labourLawMembers;
	}
	public void setLabourLawMembers(String labourLawMembers) {
		this.labourLawMembers = labourLawMembers;
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
	public String getHomeStar() {
		return homeStar;
	}
	public void setHomeStar(String homeStar) {
		this.homeStar = homeStar;
	}
	public String getWinInfo() {
		return winInfo;
	}
	public void setWinInfo(String winInfo) {
		this.winInfo = winInfo;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getMainInfoUpdateTime() {
		return mainInfoUpdateTime;
	}
	public void setMainInfoUpdateTime(String mainInfoUpdateTime) {
		this.mainInfoUpdateTime = mainInfoUpdateTime;
	}
	public String getCompanyNames() {
		return companyNames;
	}
	public void setCompanyNames(String companyNames) {
		this.companyNames = companyNames;
	}
	public String getCompanyUnifiedCodes() {
		return companyUnifiedCodes;
	}
	public void setCompanyUnifiedCodes(String companyUnifiedCodes) {
		this.companyUnifiedCodes = companyUnifiedCodes;
	}
	public String getLabourUnionProvince() {
		return labourUnionProvince;
	}
	public void setLabourUnionProvince(String labourUnionProvince) {
		this.labourUnionProvince = labourUnionProvince;
	}
	public String getLabourUnionCity() {
		return labourUnionCity;
	}
	public void setLabourUnionCity(String labourUnionCity) {
		this.labourUnionCity = labourUnionCity;
	}
	public String getLabourUnionArea() {
		return labourUnionArea;
	}
	public void setLabourUnionArea(String labourUnionArea) {
		this.labourUnionArea = labourUnionArea;
	}
	public String getLabourUnionStreet() {
		return labourUnionStreet;
	}
	public void setLabourUnionStreet(String labourUnionStreet) {
		this.labourUnionStreet = labourUnionStreet;
	}
	public String getLabourUnionIndustry() {
		return labourUnionIndustry;
	}
	public void setLabourUnionIndustry(String labourUnionIndustry) {
		this.labourUnionIndustry = labourUnionIndustry;
	}
	public String getLabourUnionNature() {
		return labourUnionNature;
	}
	public void setLabourUnionNature(String labourUnionNature) {
		this.labourUnionNature = labourUnionNature;
	}
	public String getLabourUnionLevel() {
		return labourUnionLevel;
	}
	public void setLabourUnionLevel(String labourUnionLevel) {
		this.labourUnionLevel = labourUnionLevel;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
	
	
}
