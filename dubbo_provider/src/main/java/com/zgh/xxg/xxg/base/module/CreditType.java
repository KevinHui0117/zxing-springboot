package com.zgh.xxg.xxg.base.module;

import com.zgh.xxg.xxg.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value="CreditType")
public class CreditType extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String TIME_LIMIT_TYPE_TEMP="1";//临时性
	public static final String TIME_LIMIT_TYPE_LONG="2";//长期
	
	public static final String DAY_TYPE_TODAY="1";//本日
	public static final String DAY_TYPE_24HOUR="2";//24小时
	public static final String DAY_TYPE_MONTH="3";//本月
	public static final String DAY_TYPE_YEAR="4";//本年
	
	

	private String creditTypeCode;	//征信类型编码
	private String creditTypeName;	//征信类型名称
	private String timeLimitType;	//时效类型
	private String dayType;		//时效时间段
	private int days; 		//时效天数
	private String status; 	//状态，是否启用
	
	
	public String getCreditTypeCode() {
		return creditTypeCode;
	}
	public void setCreditTypeCode(String creditTypeCode) {
		this.creditTypeCode = creditTypeCode;
	}
	public String getCreditTypeName() {
		return creditTypeName;
	}
	public void setCreditTypeName(String creditTypeName) {
		this.creditTypeName = creditTypeName;
	}
	public String getTimeLimitType() {
		return timeLimitType;
	}
	public void setTimeLimitType(String timeLimitType) {
		this.timeLimitType = timeLimitType;
	}
	public String getDayType() {
		return dayType;
	}
	public void setDayType(String dayType) {
		this.dayType = dayType;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public static String getEndTime(CreditType creditType, String startTime){
		if(creditType==null || StringUtils.isBlank(startTime) || startTime.length()<10){
			return null;
		}
		if(startTime.length()==10){
			startTime=startTime +" 00:00:00";
		}
		
		if(TIME_LIMIT_TYPE_LONG.equals(creditType.getTimeLimitType())){
			return "2099-12-31 00:00:00";
		}else if(TIME_LIMIT_TYPE_TEMP.equals(creditType.getTimeLimitType())){
			if(DAY_TYPE_TODAY.equals(creditType.getDayType())){
				return startTime.substring(0,10)+" 23:59:59";
			}else if(DAY_TYPE_24HOUR.equals(creditType.getDayType())){
				return	TimeUtil.getDateAdd(startTime, TimeUtil.AREA_HOUR, 24, TimeUtil.FORMAT_DATETIME);
			}else if(DAY_TYPE_MONTH.equals(creditType.getDayType())){
				return	TimeUtil.getLastDayOfMonth(startTime,  TimeUtil.FORMAT_DATETIME);
			}else if(DAY_TYPE_YEAR.equals(creditType.getDayType())){
				return startTime.substring(0,4)+"-12-31 23:59:59";
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	
}
