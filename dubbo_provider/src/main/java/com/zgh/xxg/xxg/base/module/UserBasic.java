package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserBasic")
public class UserBasic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;		//主键
	private long userId;	//用户ID
	
	private String marry;		//婚姻状态
	private String marryTime;  //结婚年份-2010
	private String country;		//国籍
	private String nation;		//民族
	private String addressType;		//户籍类型
	private String province;		//户籍-省,包括直辖市 
	private String city;		//户籍-地市，如果是直辖市，此处为区
	private String area;		//户籍-区，如果是直辖市，此处为街道
	private String nowProvince;		//现居地-省,包括直辖市
	private String nowCity;		//现居地-地市，
	private String nowArea;		//现居地-区，
	private String nowStreet;     //现居地 - 街道
	private String address;		//住址
	
	private String photoAddress;	//照片地址
	private String birthStatus;		//生育状态
	private int childNumber;		//子女个数
	private String health;		//健康状态
	private String politics;		//政治面貌
	private String stationStatus;		//岗位状态
	private String education;		//学历
	private String degree;         //学位
	private String skillLevel;		//技术等级
	private String workStatus;		//就业状态
	private String job;		//职务
	private String jobLevel;	//职称
	private String jobRank; //职级 --oa系统专有
	private String avatar;  //头像地址
	private String dataSource;//数据来源

	private String workStartTime;		//参加工作时间

	//数据不存在数据库的
	private String jobRankName;//职称名称--仅用于oa
	private String jobName;//职务名称--仅用于oa

	private String provinceShow;		//显示户籍-省,包括直辖市
	private String cityShow;		//显示户籍-地市，如果是直辖市，此处为区
	private String areaShow;		//显示户籍-区，如果是直辖市，此处为街道
	private String nowProvinceShow;		//现居地-省,包括直辖市
	private String nowCityShow;		//现居地-地市，
	private String nowAreaShow;		//现居地-区，
	private String nowStreetShow;     //现居地 - 街道
    private String photoAddressShow;  //图片显示

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

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getMarryTime() {
		return marryTime;
	}

	public void setMarryTime(String marryTime) {
		this.marryTime = marryTime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhotoAddress() {
		return photoAddress;
	}

	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}

	public String getBirthStatus() {
		return birthStatus;
	}

	public void setBirthStatus(String birthStatus) {
		this.birthStatus = birthStatus;
	}

	public int getChildNumber() {
		return childNumber;
	}

	public void setChildNumber(int childNumber) {
		this.childNumber = childNumber;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(String stationStatus) {
		this.stationStatus = stationStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
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

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getJobRank() {
		return jobRank;
	}

	public void setJobRank(String jobRank) {
		this.jobRank = jobRank;
	}

	public String getJobRankName() {
		return jobRankName;
	}

	public void setJobRankName(String jobRankName) {
		this.jobRankName = jobRankName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getProvinceShow() {
		return provinceShow;
	}

	public void setProvinceShow(String provinceShow) {
		this.provinceShow = provinceShow;
	}

	public String getCityShow() {
		return cityShow;
	}

	public void setCityShow(String cityShow) {
		this.cityShow = cityShow;
	}

	public String getAreaShow() {
		return areaShow;
	}

	public void setAreaShow(String areaShow) {
		this.areaShow = areaShow;
	}

	public String getNowProvince() {
		return nowProvince;
	}

	public void setNowProvince(String nowProvince) {
		this.nowProvince = nowProvince;
	}

	public String getNowCity() {
		return nowCity;
	}

	public void setNowCity(String nowCity) {
		this.nowCity = nowCity;
	}

	public String getNowArea() {
		return nowArea;
	}

	public void setNowArea(String nowArea) {
		this.nowArea = nowArea;
	}

	public String getNowStreet() {
		return nowStreet;
	}

	public void setNowStreet(String nowStreet) {
		this.nowStreet = nowStreet;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getNowProvinceShow() {
		return nowProvinceShow;
	}

	public void setNowProvinceShow(String nowProvinceShow) {
		this.nowProvinceShow = nowProvinceShow;
	}

	public String getNowCityShow() {
		return nowCityShow;
	}

	public void setNowCityShow(String nowCityShow) {
		this.nowCityShow = nowCityShow;
	}

	public String getNowAreaShow() {
		return nowAreaShow;
	}

	public void setNowAreaShow(String nowAreaShow) {
		this.nowAreaShow = nowAreaShow;
	}

	public String getNowStreetShow() {
		return nowStreetShow;
	}

	public void setNowStreetShow(String nowStreetShow) {
		this.nowStreetShow = nowStreetShow;
	}

	public String getPhotoAddressShow() {
		return photoAddressShow;
	}

	public void setPhotoAddressShow(String photoAddressShow) {
		this.photoAddressShow = photoAddressShow;
	}
}
