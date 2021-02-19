package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserBusiness")
public class UserBusiness implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Long id;		//主键
	private long userId;	//用户唯一标识 

	private String joinLabourUnionTime;		//入会时间
	private String modelWorkerType;	 //劳模类型
	private String modelWorkerStatus;		//劳模状态
	private String modelWorkerLevel;		//劳模级别
	private String encourageType;		//奖励类型
	private String poorType;	//困难类型
	private String ifOutSide;		//是否外来务工人员
	private String ifLabourUnionCadre;  //是否工会干部
	private String labourUnionCadreType;		//工会干部类型
	private String ifLabourUnionOtherCadre;		//是否工会专干
	private String ifLabourUnionGoodOtherCadre;  //是否优秀工会专干
	private String ifMemberCard;	//是否办理工会会员卡
	private String memberCardCode;		//工会会员卡号
	private String memberCardBank;		//工会会员卡开户银行
	private String memberCardType;		//工会会员卡类型
	private String releaseStatus;//发放状态
	private String sendTime;//发放时间、获取工会卡时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getJoinLabourUnionTime() {
		return joinLabourUnionTime;
	}
	public void setJoinLabourUnionTime(String joinLabourUnionTime) {
		this.joinLabourUnionTime = joinLabourUnionTime;
	}
	public String getModelWorkerType() {
		return modelWorkerType;
	}
	public void setModelWorkerType(String modelWorkerType) {
		this.modelWorkerType = modelWorkerType;
	}
	public String getModelWorkerStatus() {
		return modelWorkerStatus;
	}
	public void setModelWorkerStatus(String modelWorkerStatus) {
		this.modelWorkerStatus = modelWorkerStatus;
	}
	public String getModelWorkerLevel() {
		return modelWorkerLevel;
	}
	public void setModelWorkerLevel(String modelWorkerLevel) {
		this.modelWorkerLevel = modelWorkerLevel;
	}
	public String getEncourageType() {
		return encourageType;
	}
	public void setEncourageType(String encourageType) {
		this.encourageType = encourageType;
	}
	public String getPoorType() {
		return poorType;
	}
	public void setPoorType(String poorType) {
		this.poorType = poorType;
	}
	public String getIfOutSide() {
		return ifOutSide;
	}
	public void setIfOutSide(String ifOutSide) {
		this.ifOutSide = ifOutSide;
	}
	public String getIfLabourUnionCadre() {
		return ifLabourUnionCadre;
	}
	public void setIfLabourUnionCadre(String ifLabourUnionCadre) {
		this.ifLabourUnionCadre = ifLabourUnionCadre;
	}
	public String getLabourUnionCadreType() {
		return labourUnionCadreType;
	}
	public void setLabourUnionCadreType(String labourUnionCadreType) {
		this.labourUnionCadreType = labourUnionCadreType;
	}
	public String getIfLabourUnionOtherCadre() {
		return ifLabourUnionOtherCadre;
	}
	public void setIfLabourUnionOtherCadre(String ifLabourUnionOtherCadre) {
		this.ifLabourUnionOtherCadre = ifLabourUnionOtherCadre;
	}
	public String getIfLabourUnionGoodOtherCadre() {
		return ifLabourUnionGoodOtherCadre;
	}
	public void setIfLabourUnionGoodOtherCadre(String ifLabourUnionGoodOtherCadre) {
		this.ifLabourUnionGoodOtherCadre = ifLabourUnionGoodOtherCadre;
	}
	public String getIfMemberCard() {
		return ifMemberCard;
	}
	public void setIfMemberCard(String ifMemberCard) {
		this.ifMemberCard = ifMemberCard;
	}
	public String getMemberCardCode() {
		return memberCardCode;
	}
	public void setMemberCardCode(String memberCardCode) {
		this.memberCardCode = memberCardCode;
	}
	public String getMemberCardBank() {
		return memberCardBank;
	}
	public void setMemberCardBank(String memberCardBank) {
		this.memberCardBank = memberCardBank;
	}
	public String getMemberCardType() {
		return memberCardType;
	}
	public void setMemberCardType(String memberCardType) {
		this.memberCardType = memberCardType;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
}
