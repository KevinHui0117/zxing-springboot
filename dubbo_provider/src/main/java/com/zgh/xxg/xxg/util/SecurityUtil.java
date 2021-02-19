package com.zgh.xxg.xxg.util;

import org.apache.commons.lang3.StringUtils;


public class SecurityUtil {
	
    /**
     * 证件号转星号
     */
    public static String idToStar(String id_no){
    	if(StringUtils.isBlank(id_no)){
    		return null;
    	}
    	if(id_no.length()==15){
    		return id_no.substring(0,6)+"******"+id_no.substring(12);
    	}else if(id_no.length()==18){
    		return id_no.substring(0,6)+"********"+id_no.substring(14);
    	}else{
    		if(id_no.length()>6){
    			return id_no.substring(0,3)+"******"+id_no.substring(id_no.length()-3);
    		}else{
    			return id_no.substring(0,1)+"*****";
    		}
    	}
    }
    
    /**
     * 姓名星号处理
     */
    public static String nameToStar(String name){
    	if(StringUtils.isBlank(name)){
    		return null;
    	}
    	return name.substring(0,1)+name.substring(1).replaceAll("[\\u4e00-\\u9fa5]", "*");
    }
    
    
    //手机号码星号处理
    public static String mobileToStar(String mobile){
    	if(StringUtils.isBlank(mobile)){
    		return mobile;
    	}
    	try{
    		return mobile.substring(0, 3)+"****"+mobile.substring(7);
    		
    	}catch(Exception ex){
    		return mobile;	
    	}
    	
    }
    
    
    //邮箱星号处理
    public static String emailToStar(String email){
    	if(StringUtils.isBlank(email)){
    		return email;
    	}
    	int index=email.indexOf("@");
    	StringBuilder sb=new StringBuilder();
    	if(index<3){
    		sb.append(email.substring(0,index));
    	}else{
    		sb.append(email.substring(0,3));
    	}
    	sb.append("***");
    	sb.append(email.substring(index));
    	return sb.toString();
    }
}
