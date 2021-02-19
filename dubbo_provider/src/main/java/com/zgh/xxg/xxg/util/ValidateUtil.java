package com.zgh.xxg.xxg.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证辅助类
 */
public class ValidateUtil {
	
	private static final String onlyNum = "^[0-9]*{1}";
	/** 
	* 验证身份证号码 
	* @param id_number 
	* @return 
	*/  
	public static Boolean checkNID(String id_number){  
		if(id_number.length() != 15 && id_number.length() != 18){  
			return false;  
		}  
		String string = id_number.substring(0, id_number.length() - 1);  
		if(!string.matches(onlyNum)){  
			return false;  
		}  
		return true;  
	}  
	
    /**
     * 验证小数
     * @param number
     * @return
     */
    public static boolean isDecimal(String number){
    	String num = "^(([0-9]*).([0-9]{1,2}))|(([0-9]*))$";
    	Pattern p = Pattern.compile(num);
    	Matcher m = p.matcher(number);
    	return m.matches();
    }
	
	/** 
	* 验证邮箱 
	* @param email 
	* @return 
	*/  
	  
	public static Boolean checkEmail(String email) {  
		String check = "^[a-zA-Z0-9_-]+\\@{1}[a-zA-Z0-9_-]+(\\.{1}[a-zA-Z0-9_-]+)+$";  
		Pattern regex = Pattern.compile(check);  
		Matcher matcher = regex.matcher(email);  
		boolean isMatched = matcher.matches();  
		return isMatched;  
	}
	
	/**手机号码验证
	 * @param mobile
	 * @return 验证结果
	 */
	public static Boolean checkMoblie(String mobile){
		String mobileRegex="^\\d{11}$";
		Pattern regex = Pattern.compile(mobileRegex);
		Matcher matcher = regex.matcher(mobile);
		return matcher.matches();
	}
	
	/**电话号码验证
	 * @param phonenumber
	 * @return 验证结果
	 */
    public static boolean isTelephone(String phonenumber) {
    	String phone = "^(0\\d{2,3}-?)?\\d{7,8}$";
        Pattern p = Pattern.compile(phone);
        Matcher m = p.matcher(phonenumber);
        return m.matches();
    }
    
    /**
     * 验证金额
     * @param moneyNum
     * @return
     */
    public static boolean isMoney(String moneyNum){
    	String money = "(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$";
    	Pattern p = Pattern.compile(money);
    	Matcher m = p.matcher(moneyNum);
    	return m.matches();
    }
    
    
    /**
     * 验证数字
     * @param number
     * @return
     */
    public static boolean isNumber(String number){
    	String num = "^[1-9]\\d*$";
    	Pattern p = Pattern.compile(num);
    	Matcher m = p.matcher(number);
    	return m.matches();
    }
    
    /**
     * 验证时间	
     * @param time
     * @return
     */
    public static boolean isTime(String time){
    	String t = "^\\d{4}-(0?[1-9]|[1][012])-(0?[1-9]|[12][0-9]|[3][01])[\\s]+([0-1][0-9]|2?[0-3]):([0-5][0-9]):([0-5][0-9])$";
    	Pattern p = Pattern.compile(t);
    	Matcher m = p.matcher(time);
    	return m.matches();
    }
    
    /**
     * 验证时间 格式:yyyy-MM-dd
     * @param time
     * @return
     */
    public static boolean isDate(String time){
    	String t = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
    	Pattern p = Pattern.compile(t);
    	Matcher m = p.matcher(time);
    	return m.matches();
    }
    
    /**
     * 验证开始截止时间是否合法
     * @param time
     * @return
     */
    public static boolean checkStartAndEndTime(String startTime,String endTime){
    	if(StringUtils.isNotBlank(startTime)){
    		if(isDate(startTime)){
    			startTime=startTime+" 00:00:00";
    		}
    		if(!isTime(startTime)){
    			return false;
    		}
    	}else{
    		startTime="0";
    	}
    	
    	if(StringUtils.isNotBlank(endTime)){
    		if(isDate(endTime)){
    			endTime=endTime+" 00:00:00";
    		}
    		if(!isTime(endTime)){
    			return false;
    		}
    	}else{
    		endTime="3999-12-31 00:00:00";
    	}
    	
    	if(startTime.compareTo(endTime)<=0){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    
    
    
    /**检验车牌号
     * @param vehicle_no
     * @return
     */
    public static boolean isVehicle(String vehicle_no) {  
    	String t = "^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9_\u4e00-\u9fa5]{5}$";
    	Pattern p = Pattern.compile(t);
    	Matcher m = p.matcher(vehicle_no);
    	return m.matches();
    	
    } 
   
    /**  
     * 校验银行卡卡号  
     * @param cardId 银行卡卡号
     * @return 校验结果
     */   
    public static boolean checkBankCard(String cardId) {  
    	char  bit = getBankCardCheckCode(cardId.substring( 0 , cardId.length() -  1 ));  
    	if (bit ==  'N' ){  
    		return   false ;  
    	}  
    	return  cardId.charAt(cardId.length() -  1 ) == bit;  
    } 
    
    /**  
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位  
     * @param nonCheckCodeCardId  
     * @return  校验结果
     */   
    public static char getBankCardCheckCode(String nonCheckCodeCardId){  
        if (nonCheckCodeCardId ==  null  || nonCheckCodeCardId.trim().length() ==  0   
                || !nonCheckCodeCardId.matches("\\d+" )) {  
         //如果传的不是数据返回N   
            return   'N' ;  
        }  
        char [] chs = nonCheckCodeCardId.trim().toCharArray();  
        int  luhmSum =  0 ;  
        for ( int  i = chs.length -  1 , j =  0 ; i >=  0 ; i--, j++) {  
            int  k = chs[i] -  '0' ;  
            if (j %  2  ==  0 ) {  
                k *= 2 ;  
                k = k / 10  + k %  10 ;  
            }  
            luhmSum += k;             
        }  
        return  (luhmSum %  10  ==  0 ) ?  '0'  : ( char )(( 10  - luhmSum %  10 ) +  '0' );  
    }
    
    /**
     * 判断输入的字符串是否满足时间格式 ： yyyy-MM-dd HH:mm:ss
     * @param patternString 需要验证的字符串
     * @return 合法返回 true ; 不合法返回false
     */
    public static boolean isTimeLegal(String patternString) {
           
        Pattern a=Pattern.compile("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$"); 
    
        Matcher b=a.matcher(patternString); 
        if(b.matches()) {
              return true;
         } else {
               return false;
         }
    }
    
    /**
     * 验证组织机构代码
     * @param number
     * @return
     */
    public static boolean isOrg_code(String org_code){
    	String num = "^[0-9A-Z]{8}-{1}[0-9A-Z]{1}$";
    	Pattern p = Pattern.compile(num);
    	Matcher m = p.matcher(org_code);
    	return m.matches();
    }
    
    /**
     * 验证营业执照号
     * @param number
     * @return
     */
    public static boolean isLicense_no(String license_no){
    	String num = "^[0-9]{15}$";
    	Pattern p = Pattern.compile(num);
    	Matcher m = p.matcher(license_no);
    	return m.matches();
    }
    
    /**
     * 验证税务登记号
     * @param number
     * @return
     */
    public static boolean isTax_no(String tax_no){
    	String num = "^[0-9A-Z]{15}$";
    	Pattern p = Pattern.compile(num);
    	Matcher m = p.matcher(tax_no);
    	return m.matches();
    }
    
    /**
     * 验证传真号码
     * @param number
     * @return
     */
    public static boolean isFax_no(String fax_no){
    	String fax = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$";
    	Pattern p = Pattern.compile(fax);
    	Matcher m = p.matcher(fax_no);
    	return m.matches();
    }
    
    /**
     * 判断网络是否正常连接
     * @param addr
     * @return
     */
    public static boolean isConnect(String addr){
    	URL url = null;  
        try {  
            url = new URL(addr);  
            try {  
                InputStream in = url.openStream();  
                in.close();  
                return true; 
            } catch (IOException e) {  
                return false;
            }  
        } catch (MalformedURLException e) {  
            return false;
        } 
    }
    
}
