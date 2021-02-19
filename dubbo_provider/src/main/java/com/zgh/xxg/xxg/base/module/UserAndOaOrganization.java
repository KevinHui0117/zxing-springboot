package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="UserAndOaOrganization")
public class UserAndOaOrganization extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private long userId;   //用户ID
	private long organizationId;	//组织ID
	private String status;		//状态 1：可用的   0：删除的
	private String linkType;	//关联类型  1:主单位（主部门）2：副的
	private String startTime;	//开始时间
	private String endTime;		//结束时间
	private String inReason;	//进入原因
	private String outReason;		//离开原因
	
	//以下数据不存数据库
	private String  organizationName;
	private String fullName;
	private String mobile;
    private String sex; //性别
    private String email;
    private String job; // 职务
    private String jobRank; //职级
    private String politics;  //政治面貌
    private String phone; //固定电话
    private String ifLabourUnionOtherCadre; //是否工会专干
    private String ifMemberCard;  //是否有会员卡
    
    private String departmentName; //oa部门
	private String bigDepartmentName;//OA单位

	private String userStatus; //用户状态
	private String organizationStatus; //组织状态
	private String oaUseStatus;// oa用户是否启用
	

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobRank() {
        return jobRank;
    }

    public void setJobRank(String jobRank) {
        this.jobRank = jobRank;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIfLabourUnionOtherCadre() {
        return ifLabourUnionOtherCadre;
    }

    public void setIfLabourUnionOtherCadre(String ifLabourUnionOtherCadre) {
        this.ifLabourUnionOtherCadre = ifLabourUnionOtherCadre;
    }

    public String getIfMemberCard() {
        return ifMemberCard;
    }

    public void setIfMemberCard(String ifMemberCard) {
        this.ifMemberCard = ifMemberCard;
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

	public String getOaUseStatus() {
		return oaUseStatus;
	}

	public void setOaUseStatus(String oaUseStatus) {
		this.oaUseStatus = oaUseStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
