package com.zgh.xxg.xxg.base.module;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;


@Alias(value="Attribute")
public class Attribute extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String ATTRIBUTE_TYPE_PERSON="1";
	public static final String ATTRIBUTE_TYPE_LABOUR="2";
	public static final String ATTRIBUTE_TYPE_COMPANY="3";
	
	
	private String attributeType;		//类型：自然人、法人
	private String recordId;		//记录ID
	private String attributeName;		//名称
	private String newValue;		//新值
	private String source;		//来源：信息中心、质监局
	private String sourceTime;		//获取时间
	private String newUpdateTime;		//属性的更新时间
	private String oldValue;		//属性旧值
	
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		if(StringUtils.isNotBlank(newValue)){
			if(newValue.length()>500){
				newValue=newValue.substring(0,500);
			}
		}
		this.newValue = newValue;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceTime() {
		return sourceTime;
	}
	public void setSourceTime(String sourceTime) {
		this.sourceTime = sourceTime;
	}
	public String getNewUpdateTime() {
		return newUpdateTime;
	}
	public void setNewUpdateTime(String newUpdateTime) {
		this.newUpdateTime = newUpdateTime;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		if(StringUtils.isNotBlank(oldValue)){
			if(oldValue.length()>500){
				oldValue=oldValue.substring(0,500);
			}
		}
		this.oldValue = oldValue;
	}
	
	
	
	
	
}
