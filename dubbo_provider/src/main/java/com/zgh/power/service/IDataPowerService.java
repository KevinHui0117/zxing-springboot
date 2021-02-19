package com.zgh.power.service;




import com.zgh.xxg.xxg.base.module.Operater;

import java.util.Map;

public interface IDataPowerService {

	public static final String  BUSINESS="business";
	public static final String  OA="oa";
	
	
	/**
	 * 检查是不是超级管理员
	 * */
	public boolean checkIfSuperAdmin(Operater operater);
	
	
	/**
	 * 数据权限控制：在查询条件中增加组织编码和用户ID,对数据进行过滤,dataName：被查询的数据
	 * */
	public Map<String, Object> setPower(Map<String, Object> params, String dataName, Operater operater);

	/**
	 * 检查操作者是否有权限操作该数据
	 * userId：被操作的数据的userId
	 * dataCode:被操作数据的数据权限代码
	 * dataName:被操作数据的名称，如：用户、考勤、固定资产等
	 * */
	public void checkPower(long userId, long orgId, String dataName, Operater operater, String businessOrOa);
}
