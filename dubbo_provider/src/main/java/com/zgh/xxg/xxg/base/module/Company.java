package com.zgh.xxg.xxg.base.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="Company")
@ApiModel(description = "公司")
public class Company extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="单位名称")
    private String companyName;
    @ApiModelProperty(value="单位属性")
    private String companyMean;
    @ApiModelProperty(value="单位统一社会信用代码")
    private String companyUnifiedCode;
    @ApiModelProperty(value="成立日期")
    private String companyCreateTime;
    @ApiModelProperty(value="单位法人代表")
    private String companyLawPerson;
    @ApiModelProperty(value="单位所属行业")
    private String companyIndustry;
    @ApiModelProperty(value="单位性质类别")
    private String companyNature;
    @ApiModelProperty(value="单位经济类型")
    private String companyType;
    @ApiModelProperty(value="单位邮编")
    private String companyPostcode;
    @ApiModelProperty(value="单位注册地址")
    private String companyRegAddress;
    @ApiModelProperty(value="单位实际经营地址")
    private String companyRealAddress;
    @ApiModelProperty(value="单位所在省")
    private String companyProvince;
    @ApiModelProperty(value="单位所在市")
    private String companyCity;
    @ApiModelProperty(value="单位所在区")
    private String companyArea;
    @ApiModelProperty(value="单位所在镇街")
    private String companyStreet;
    @ApiModelProperty(value="党组织建立情况")
    private String partyStatus;

    @ApiModelProperty(value="法人代表证件类型")
    private String companyLawPersonIdCardType;
    @ApiModelProperty(value="法人代表证件号码")
    private String companyLawPersonIdCardCode;
    @ApiModelProperty(value="单位联系电话")
    private String companyTel;
    @ApiModelProperty(value="单位状态")
    private String companyStatus;
    @ApiModelProperty(value="所属群体--工会会员系统-入会申请时所需-数据字典")
    private String groups;

    //以下信息不存数据库，仅作展现使用
    @ApiModelProperty(value="所属工会ID")
    private long labourUnionId;
    @ApiModelProperty(value="所属工会名称")
    private String labourUnionName;
    @ApiModelProperty(value="上级工会ID")
    private long parentId;
    @ApiModelProperty(value="上级工会名称")
    private String parentName;
    @ApiModelProperty(value="优先建会")
    private String priorEstablishUnionPeople;

    @ApiModelProperty(value="单位所属省会显示名称")
    private String  companyProvinceShow;
    @ApiModelProperty(value="单位所属城市显示名称")
    private String  companyCityShow;
    @ApiModelProperty(value="单位所属区域显示名称")
    private String  companyAreaShow;
    @ApiModelProperty(value="单位所属街道显示名称")
    private String  companyStreetShow;
    @ApiModelProperty(value="单位性质类别名称")
    private String 	companyNatureName;
    @ApiModelProperty(value="单位经济类型")
    private String 	companyIndustryName;
    @ApiModelProperty(value="单位类别名称")
    private String 	companyTypeName;
    @ApiModelProperty(value="单位属性名称")
    private String 	companyMeanName;
    @ApiModelProperty(value="单位法人代表证件类型名称")
    private String  companyLawPersonIdCardTypeName;
    @ApiModelProperty(value="单位属性")
    private String companyproperty; //单位属性

    public String getCompanyproperty() {        return companyproperty;    }
    public void setCompanyproperty(String companyproperty) {        this.companyproperty = companyproperty;    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyMean() {
        return companyMean;
    }
    public void setCompanyMean(String companyMean) {
        this.companyMean = companyMean;
    }
    public String getCompanyUnifiedCode() {
        return companyUnifiedCode;
    }
    public void setCompanyUnifiedCode(String companyUnifiedCode) {
        this.companyUnifiedCode = companyUnifiedCode;
    }
    public String getCompanyCreateTime() {
        return companyCreateTime;
    }
    public void setCompanyCreateTime(String companyCreateTime) {
        this.companyCreateTime = companyCreateTime;
    }
    public String getCompanyLawPerson() {
        return companyLawPerson;
    }
    public void setCompanyLawPerson(String companyLawPerson) {
        this.companyLawPerson = companyLawPerson;
    }
    public String getCompanyIndustry() {
        return companyIndustry;
    }
    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }
    public String getCompanyNature() {
        return companyNature;
    }
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }
    public String getCompanyType() {
        return companyType;
    }
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    public String getCompanyPostcode() {
        return companyPostcode;
    }
    public void setCompanyPostcode(String companyPostcode) {
        this.companyPostcode = companyPostcode;
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
    public String getCompanyTel() {
        return companyTel;
    }
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }
    public String getCompanyStatus() {
        return companyStatus;
    }
    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }
    public long getLabourUnionId() {
        return labourUnionId;
    }
    public void setLabourUnionId(long labourUnionId) {
        this.labourUnionId = labourUnionId;
    }
    public String getLabourUnionName() {
        return labourUnionName;
    }
    public void setLabourUnionName(String labourUnionName) {
        this.labourUnionName = labourUnionName;
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

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getPriorEstablishUnionPeople() {   return this.priorEstablishUnionPeople;  }
    public void setPriorEstablishUnionPeople(String priorEstablishUnionPeople) {    this.priorEstablishUnionPeople = priorEstablishUnionPeople;    }


}
