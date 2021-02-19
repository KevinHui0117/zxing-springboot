package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="LabourUnionHistory")
public class LabourUnionHistory extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String CHANGE_ITEM_PARENT="上级单位";
	public static final String CHANGE_ITEM_LABOURUNION_NAME="工会名称";
	public static final String CHANGE_ITEM_LABOURUNION_UNIFIED_CODE="工会统一社会信用代码";
	public static final String CHANGE_ITEM_LABOURUNION_LAWPERSON="工会法人代表";
	public static final String CHANGE_ITEM_LABOURUNION_TIME="工会有效期限";
	
	

	private long labourUnionId;		//工会ID
	private String changeItem;		//更改项
	private String oldValue;	   //更改前值
	private long oldId;
	private String newValue;	   //更改后值
	private long newId;
	private String changeDate;		//变更日期
	private long changer;		//变更人 
	private String changeReason;		//变更原因
	
	


	//以下信息不存数据库
	private String changerName;		//更改人
	private String labourUnionName;	//工会名称
	
	public long getLabourUnionId() {
		return labourUnionId;
	}
	public void setLabourUnionId(long labourUnionId) {
		this.labourUnionId = labourUnionId;
	}
	public String getChangeItem() {
		return changeItem;
	}
	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public long getOldId() {
		return oldId;
	}
	public void setOldId(long oldId) {
		this.oldId = oldId;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public long getNewId() {
		return newId;
	}
	public void setNewId(long newId) {
		this.newId = newId;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public long getChanger() {
		return changer;
	}
	public void setChanger(long changer) {
		this.changer = changer;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	
	public String getChangerName() {
		return changerName;
	}
	public void setChangerName(String changerName) {
		this.changerName = changerName;
	}
	public String getLabourUnionName() {
		return labourUnionName;
	}
	public void setLabourUnionName(String labourUnionName) {
		this.labourUnionName = labourUnionName;
	}
	
	
	
	
}
