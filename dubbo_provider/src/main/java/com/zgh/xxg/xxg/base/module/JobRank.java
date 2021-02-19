package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="JobRank")
public class JobRank extends BaseEntity implements Serializable,Comparable<JobRank>{

	private static final long serialVersionUID = 1L;
	

	private String jobRankCode;	//职级编码
	private String jobRankName;	//职级名称
	private long parentId;		//上级分类ID
	private String status;		//状态
		
	
	//以下信息不存数据库
	private String parentName;	//上级名称

	
	public String getJobRankCode() {
		return jobRankCode;
	}

	public void setJobRankCode(String jobRankCode) {
		this.jobRankCode = jobRankCode;
	}




	public String getJobRankName() {
		return jobRankName;
	}




	public void setJobRankName(String jobRankName) {
		this.jobRankName = jobRankName;
	}




	public long getParentId() {
		return parentId;
	}




	public void setParentId(long parentId) {
		this.parentId = parentId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	@Override
	public int compareTo(JobRank industry) {
		return this.jobRankCode.compareToIgnoreCase(industry.getJobRankCode());
	}
	
	
}
