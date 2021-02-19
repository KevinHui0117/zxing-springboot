package com.zgh.xxg.xxg.exception;


/**
 * 基础异常类
 * 约定：异常代码为5位，格式为:
 * 	13XXX,14XXX,15XXX
 * 	23XXX,24XXX,25XXX
 * 异常代码1开头的异常信息，可以直接显示给外部用户，异常代码为2开头的异常不允许直接显示给外部用户
 * 异常代码的第2位只能是3,4,5
 * 异常代码第2位是3表示输入方错误，比如输入不全，或者输入的类型不正确
 * 异常代码第2位是4表示服务端找不到相关的信息
 * 异常代码第2位是5表示服务端经过运行后返回的业务错误
 * */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	
  	 public static final int  NO_OPERATER=23999;
  	 public static final String  NO_OPERATER_MESSAGE="没有指定操作者信息";
  	 public static final int MONEY_ERROR=13998;
  	 public static final String  MONEY_ERROR_MESSAGE="操作金额不合法";
  	 public static final int DATETIME_ERROR=13997;
  	 public static final String  DATETIME_ERROR_MESSAGE="日期时间格式错误";
  	 public static final int  ENDTIME_BEFORE_STARTTIME=13996;
  	 public static final String  ENDTIME_BEFORE_STARTTIME_MESSAGE="截止时间早于开始时间或格式错误";
  	 public static final int  EMAIL_ERROR=13995;
  	 public static final String  EMAIL_ERROR_MESSAGE="Email格式错误";
  	 public static final int  MOBILE_ERROR=13994;
 	 public static final String  MOBILE_ERROR_MESSAGE="手机号码不合法";
 	 public static final int  TEL_ERROR=13993;
	 public static final String  TEL_ERROR_MESSAGE="固定电话号码不合法";
	 public static final int  NUMBER_ERROR=13992;
	 public static final String NUMBER_ERROR_MESSAGE="数字格式错误";
	 public static final int  IP_ERROR=13991;
	 public static final String IP_ERROR_MESSAGE="IP地址格式错误";
	 public static final int  AUDIT_NO_REASON=13990;
	 public static final String AUDIT_NO_REASON_MESSAGE="没有指定审核失败的原因";
	 public static final int  NO_POWER=13899;
	 public static final String NO_POWER_MESSAGE="没有操作权限";
	 public static final int NULL=23898;
	 public static final String NULL_MESSAGE="不允许为空的参数为空";
	 public static final int EDIT_LOCK=13897;
	 public static final String EDIT_LOCK_MESSAGE="该记录已被其他用户锁定";
	 
	 
	 public static final int  NO_RECORD=24999;
  	 public static final String  NO_RECORD_MESSAGE="被操作记录不存在";
  	 
  	
	 public static final int  UNKNOW_ERROR=25999;
  	 public static final String  UNKNOW_ERROR_MESSAGE="未知错误";
  	 public static final int  CONCURRENT_ERROR=25998;
  	 public static final String  CONCURRENT_ERROR_MESSAGE="并发冲突";
  	 public static final int  REQUEST_ERROR=15997;
  	 public static final String  REQUEST_ERROR_MESSAGE="请求失败";
  	 
  	 
  	 public static final int COMMON_ERROR=15001;
  	 public static final int OTHER_ERROR=25001;
 	 
  			 
  	 
	private int code;

	public BaseException() {
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(int code) {
		this.code = code;
	}

	public BaseException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public BaseException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
