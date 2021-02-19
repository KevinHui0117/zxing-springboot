package com.zgh.xxg.xxg.base.module;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "OperateLog")
public class OperateLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String LOG_TYPE_LOGIN="登录";
	public static final String LOG_TYPE_LOGIN_LABOURUNION="工会登录";
	public static final String LOG_TYPE_LOGOUT="退出";
	public static final String LOG_TYPE_QUERY = "查询";
	public static final String LOG_TYPE_INSERT = "新增";
	public static final String LOG_TYPE_DELETE = "删除";
	public static final String LOG_TYPE_UPDATE = "修改";
	public static final String LOG_TYPE_PRINT = "打印";
	public static final String LOG_TYPE_IMPORT = "导入";
	public static final String LOG_TYPE_EXPORT = "导出";
	public static final String LOG_TYPE_OTHER = "其他";

	private Long id;		//主键
	
	private String logType;		//日志类型
	private String systemName;	//系统名称
	private String systemCode;	//系统编码
	private String ifCluster;	//系统是否集群
	private String clusterNode;	//集群节点
	private String systemIp;	//系统IP地址
	private String operateModule;	//功能模块
	private String operateSubModule;	//子模块
	private String operateData;	//操作的业务数据（主数据）
	private String operateParam;	//操作参数
	private String operateStatus;	//操作状态 成功或失败
	private String operateResult;	//操作结果 查询的结果，或者新增，删除、修改受影响的行数
	private String errorMessage;	//错误信息
	private String note;		//备注
	
	private long operaterId; // 操作人ID
	private String operaterName; // 操作人
	private String operaterIp;		//操作人所在IP
	private String operateTime; // 操作时间
	private String businessCode;		//业务唯一标识
	private String dataCode;		//数据权限代码
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getOperateModule() {
		return operateModule;
	}
	public void setOperateModule(String operateModule) {
		this.operateModule = operateModule;
	}
	public String getOperateSubModule() {
		return operateSubModule;
	}
	public void setOperateSubModule(String operateSubModule) {
		this.operateSubModule = operateSubModule;
	}
	public String getIfCluster() {
		return ifCluster;
	}
	public void setIfCluster(String ifCluster) {
		this.ifCluster = ifCluster;
	}
	public String getClusterNode() {
		return clusterNode;
	}
	public void setClusterNode(String clusterNode) {
		this.clusterNode = clusterNode;
	}
	public String getSystemIp() {
		return systemIp;
	}
	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}
	public String getOperateData() {
		return operateData;
	}
	public void setOperateData(String operateData) {
		this.operateData = operateData;
	}
	public String getOperateParam() {
		return operateParam;
	}
	public void setOperateParam(String operateParam) {
		if(StringUtils.isNotBlank(operateParam) && operateParam.length()>1000){
			this.operateParam = operateParam.substring(0, 1000);
		}else{
			this.operateParam = operateParam;
		}
	}
	public String getOperateStatus() {
		return operateStatus;
	}
	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	}
	public String getOperateResult() {
		return operateResult;
	}
	public void setOperateResult(String operateResult) {
		if(StringUtils.isNotBlank(operateResult) && operateResult.length()>1000){
			this.operateResult = operateResult.substring(0, 1000);
		}else{
			this.operateResult = operateResult;
		}
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		if(StringUtils.isNotBlank(errorMessage) && errorMessage.length()>1000){
			this.errorMessage = errorMessage.substring(0, 1000);
		}else{
			this.errorMessage = errorMessage;
		}
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
