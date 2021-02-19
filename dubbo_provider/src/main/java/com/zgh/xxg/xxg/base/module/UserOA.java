package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserOA")
public class UserOA implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;		//主键
	private long userId;	//用户唯一标识
	private String joinArmyTime;	//入伍时间
	
	
	private String ifQuit;	//是否离职
	private String quitTime;	//离职时间
	private String phone;      //固定电话
	private String useStatus;  //是否启用 ，1启用 ，0不启用
	
	private long bid;		//B岗人员
	private String bname;   //B岗人员姓名
	private String joinTime;		//入职时间
	private String  startWorkTime;		//开始工作时间 用户专用oa数据专用-人员资料
	private String holidayType;		//探亲假类型:1父母 2配偶，3父母与配偶
	private String  nurseHoliday;		//独生子女护理假 1有 0无
	private String otherHoliday;//      其他假 1有 0无

	//不存在数据库的字段
	private long oaOrganizationId;  //与用户关联的OA组织的ID
	private String departmentName; //oa部门
	private long bigDepartmenId;	//OA单位ID
	private String bigDepartmentName;//OA单位

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

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
	public String getJoinArmyTime() {
		return joinArmyTime;
	}
	public void setJoinArmyTime(String joinArmyTime) {
		this.joinArmyTime = joinArmyTime;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public String getIfQuit() {
		return ifQuit;
	}
	public void setIfQuit(String ifQuit) {
		this.ifQuit = ifQuit;
	}
	public String getQuitTime() {
		return quitTime;
	}
	public void setQuitTime(String quitTime) {
		this.quitTime = quitTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBigDepartmentName() {
		return bigDepartmentName;
	}

	public void setBigDepartmentName(String bigDepartmentName) {
		this.bigDepartmentName = bigDepartmentName;
	}
	
	public String getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	public long getOaOrganizationId() {
		return oaOrganizationId;
	}
	public void setOaOrganizationId(long oaOrganizationId) {
		this.oaOrganizationId = oaOrganizationId;
	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(String startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	public String getHolidayType() {
		return holidayType;
	}
	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}
	public String getNurseHoliday() {
		return nurseHoliday;
	}
	public void setNurseHoliday(String nurseHoliday) {
		this.nurseHoliday = nurseHoliday;
	}

	public long getBigDepartmenId() {
		return bigDepartmenId;
	}

	public void setBigDepartmenId(long bigDepartmenId) {
		this.bigDepartmenId = bigDepartmenId;
	}

	public String getOtherHoliday() {
		return otherHoliday;
	}

	public void setOtherHoliday(String otherHoliday) {
		this.otherHoliday = otherHoliday;
	}
}
