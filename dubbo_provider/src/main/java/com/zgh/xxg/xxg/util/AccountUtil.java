package com.zgh.xxg.xxg.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class AccountUtil {
	
	//账户金额默认格式(带2位小数)
    public static final String MONEY_DEFAULT_FORMAT="#.##";
    //默认除法运算精度
    private static final int DEFAULT_DIV_SCALE = 10;
	
	/**
	 * 根据格式四舍五入
	 * @param num
	 * @param format
	 * @return
	 */
	public static String format(String num,String format){
		if(StringUtils.isBlank(num))return "0";
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(Double.parseDouble(num));
	}
	

	
	/**
	 * 
	 * @描述:    根据传入字符串,以及保留位数格式,向上取整
	 * @方法名: newFormatUp
	 * @修改备注
	 */
	public static String formatUp(String num,String format){
        if(StringUtils.isBlank(num))return "0";
        DecimalFormat df = new DecimalFormat(format);
        df.setRoundingMode(RoundingMode.CEILING);
        return  df.format(Double.parseDouble(num));
    }
	
	/**
	 * 格式向下取整
	 * @param num
	 * @param format
	 * @return
	 */
	public static String formatDown(String num,String format){
		if(StringUtils.isBlank(num))return "0";
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.DOWN);
		return df.format(Double.parseDouble(num));
	}
	
	/**
	 * 字符串数字相加
	 * @param num1
	 * @param num2
	 * @param format
	 * @return
	 */
	public static String sum(String num1,String num2,String format){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return df.format(d1 + d2);
	}
	
	/**
	 * 减法
	 * @param num1
	 * @param num2
	 * @param format
	 * @return
	 */
	public static String subtract(String num1,String num2,String format){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return df.format(d1 - d2);
	}
	
	/**
	 * 除法
	 * @param num1
	 * @param num2
	 * @param format
	 * @return
	 */
	public static String divide(String num1,String num2,String format){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		if(Double.valueOf(num2) == 0d){
			return "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return df.format(d1 / d2);
	}
	
	/**
	 * 乘法
	 * @param num1
	 * @param num2
	 * @param format
	 * @return
	 */
	public static String multiply(String num1,String num2,String format){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return df.format(d1 * d2);
	}
	
	/**
	 * bigDecimal防止丢失精度问题
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double sumBigDecimal(double v1, double v2){
	     BigDecimal b1 = new BigDecimal(Double.toString(v1));
	     BigDecimal b2 = new BigDecimal(Double.toString(v2));
	     return b1.add(b2).doubleValue();
	}
	
	public static String sumBigDecimal(String v1, String v2,String format){
		BigDecimal b1 = new BigDecimal(StringUtils.isBlank(v1)?"0":v1);
		BigDecimal b2 = new BigDecimal(StringUtils.isBlank(v2)?"0":v2);
		DecimalFormat df = new DecimalFormat(format);
		return df.format(b1.add(b2));
	}
	
	public static double subtractBigDecimal(double v1, double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	public static String subtractBigDecimal(String v1, String v2,String format){
		BigDecimal b1 = new BigDecimal(StringUtils.isBlank(v1)?"0":v1);
		BigDecimal b2 = new BigDecimal(StringUtils.isBlank(v2)?"0":v2);
		DecimalFormat df = new DecimalFormat(format);
		return df.format(b1.subtract(b2));
	}
	
	public static double multiplyBigDecimal(double v1, double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	
	public static String multiplyBigDecimal(String v1, String v2,String format){
		BigDecimal b1 = new BigDecimal(StringUtils.isBlank(v1)?"0":v1);
		BigDecimal b2 = new BigDecimal(StringUtils.isBlank(v2)?"0":v2);
		DecimalFormat df = new DecimalFormat(format);
		return df.format(b1.multiply(b2));
	}
	
	public static double divideBigDecimal(double v1, double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,DEFAULT_DIV_SCALE,BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
	public static String divideBigDecimal(String v1, String v2,String format){
		BigDecimal b1 = new BigDecimal(StringUtils.isBlank(v1)?"0":v1);
		BigDecimal b2 = new BigDecimal(StringUtils.isBlank(v2)?"0":v2);
		DecimalFormat df = new DecimalFormat(format);
		return df.format(b1.divide(b2,DEFAULT_DIV_SCALE,BigDecimal.ROUND_HALF_EVEN));
	}


	/**
	 * 大于
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean greateThan(String num1,String num2){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return d1>d2;
	}

	/**
	 * 大于等于
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean greateEqual(String num1,String num2){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return d1>=d2;
	}
	
	/**
	 * 等于
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean equal(String num1,String num2){
		if(StringUtils.isBlank(num1))num1 = "0";
		if(StringUtils.isBlank(num2))num2 = "0";
		Double d1 = new Double(num1);
		Double d2 = new Double(num2);
		return d1.equals(d2);
	}
	
	public  static void main(String[] args){
		System.out.println(AccountUtil.subtract("3.5", "0.3", "#.##"));
	}
	
}
