package com.zgh.xxg.xxg.base.module;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable{

	private Long id;				//主键

	private String dataCode;		//数据权限代码
	private String note;			//注释
	private long creater;			//创建人
	private String createName = "";		//创建人姓名
	private String createTime;		//创建时间
	private long updater;			//更新人
	private String updateName;		//更新人姓名
	private String updateTime;		//更新时间
	
	
	

	
	
}
