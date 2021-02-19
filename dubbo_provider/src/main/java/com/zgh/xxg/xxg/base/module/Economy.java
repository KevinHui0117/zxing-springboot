package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="Economy")
public class Economy extends  BaseEntity  implements Serializable,Comparable<Economy>{

	private static final long serialVersionUID = 1L;


	private String economyCode;	//经济类型编码
	private String economyName;	//经济类型名称
	private String economyType;	//经济类型类型
	private int economyLevel;	//经济类型级别
	private long parentId;		//上级分类ID
	private String status;		//状态




	//以下信息不存数据库
	private String parentName;	//上级名称




	public String getEconomyCode() {
		return economyCode;
	}




	public void setEconomyCode(String economyCode) {
		this.economyCode = economyCode;
	}




	public String getEconomyName() {
		return economyName;
	}




	public void setEconomyName(String economyName) {
		this.economyName = economyName;
	}




	public String getEconomyType() {
		return economyType;
	}




	public void setEconomyType(String economyType) {
		this.economyType = economyType;
	}




	public int getEconomyLevel() {
		return economyLevel;
	}




	public void setEconomyLevel(int economyLevel) {
		this.economyLevel = economyLevel;
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
	public int compareTo(Economy economy) {
		return this.getEconomyCode().compareToIgnoreCase(economy.getEconomyCode());
	}

}
