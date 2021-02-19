package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="OrganizationHistory")
public class OrganizationHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;		//主键
	private long organizationId;		//组织唯一标识
	private String oldOrganizationName;		//更改前的名称
	private String oldUnifiedCode;		//更改前的统一社会信用代码
	private String oldParentId;		//更改前所属工会
	private String changeDate;		//变更日期
	private String changer;		//变更人 
	private String changeStatus;		//变更状态
	
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
	public String getOldOrganizationName() {
		return oldOrganizationName;
	}
	public void setOldOrganizationName(String oldOrganizationName) {
		this.oldOrganizationName = oldOrganizationName;
	}
	public String getOldUnifiedCode() {
		return oldUnifiedCode;
	}
	public void setOldUnifiedCode(String oldUnifiedCode) {
		this.oldUnifiedCode = oldUnifiedCode;
	}
	public String getOldParentId() {
		return oldParentId;
	}
	public void setOldParentId(String oldParentId) {
		this.oldParentId = oldParentId;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public String getChangeStatus() {
		return changeStatus;
	}
	public void setChangeStatus(String changeStatus) {
		this.changeStatus = changeStatus;
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
