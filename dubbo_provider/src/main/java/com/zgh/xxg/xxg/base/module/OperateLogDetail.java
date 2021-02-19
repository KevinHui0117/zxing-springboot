package com.zgh.xxg.xxg.base.module;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "OperateLogDetail")
public class OperateLogDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String entity; // 实体类名,标记是哪个实体类
	private String operateType; // 操作类型，增、删、改
	
	private String primaryKeyValue; // 实体对象的记录Id,如客户id等通过@HistoryId自定义,默认是取Id的值
	private String primaryKeyName; // 实体对象的记录Id的属性名称,默认是Id
	private String fieldName; // 修改实体的属性名，字段名称
	private String fieldAlias; // 属性别名，字段中文名称
	private String oldValue; // 原属性值
	private String newValue; // 新属性值
	private long operaterId; // 操作人ID
	private String operaterName; // 操作人
	private String operaterIp;		//操作人所在IP
	private String operateTime; // 操作时间
	private String  businessCode;		//业务唯一标识
	private String dataCode;		//数据权限代码
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getPrimaryKeyValue() {
		return primaryKeyValue;
	}
	public void setPrimaryKeyValue(String primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}
	public String getPrimaryKeyName() {
		return primaryKeyName;
	}
	public void setPrimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldAlias() {
		return fieldAlias;
	}
	public void setFieldAlias(String fieldAlias) {
		this.fieldAlias = fieldAlias;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		if(StringUtils.isNotBlank(oldValue) && oldValue.length()>1000){
			this.oldValue = oldValue.substring(0, 1000);
		}else{
			this.oldValue = oldValue;
		}
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		if(StringUtils.isNotBlank(newValue) && newValue.length()>1000){
			this.newValue = newValue.substring(0, 1000);
		}else{
			this.newValue = newValue;
		}
	}
	public long getOperaterId() {
		return operaterId;
	}
	public void setOperaterId(long operaterId) {
		this.operaterId = operaterId;
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public String getOperaterIp() {
		return operaterIp;
	}
	public void setOperaterIp(String operaterIp) {
		this.operaterIp = operaterIp;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	
	
	
}
