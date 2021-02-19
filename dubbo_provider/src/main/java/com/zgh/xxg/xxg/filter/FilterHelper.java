package com.zgh.xxg.xxg.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FilterHelper {

	private static  Map<String, List<String>> powerMap=new HashMap<String, List<String>>();
	
	public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	public static final String X_REQUESTED_WITH = "X-Requested-With";
	 
	/*公共部分*/
	public static final String PUBLIC_ALL="public_all";
	/*公共部分(仅移动端)*/
	public static final String PUBLIC_MOBILE="public_mobile";
	/*公共部分(仅PC端)*/
	public static final String PUBLIC_PC="public_pc";
	
	public static final String UNKNOWN="-1";
	public static final String PC="1";
	public static final String APP="2";

	
	static{
		List<String> listPublicAll=new ArrayList<>();
		powerMap.put(PUBLIC_ALL,listPublicAll);
		listPublicAll.add("/login.action");	

		listPublicAll.add("/reLoginApp");
		listPublicAll.add("/setPwdApp");
		listPublicAll.add("/sendCheckCodeForApp");
		listPublicAll.add("/getOperaterApp");
		listPublicAll.add("/changePasswordApp");
		listPublicAll.add("/getNewAuthTokenApp");
		listPublicAll.add("/getOrgApp");
		listPublicAll.add("/changeOrgApp");
		listPublicAll.add("/getOperaterOrgApp");
		listPublicAll.add("/changeMobileApp");
		listPublicAll.add("/checkPwdApp");
		listPublicAll.add("/checkIdcardCodeApp");
		listPublicAll.add("/loginpostForApp");  //tested by huikai on 2020.02.18
		
		listPublicAll.add("/lostPwdFirstApp");
		listPublicAll.add("/lostPwdPhoneSubmitApp");
		listPublicAll.add("/lostPwdSendEmailApp");
		listPublicAll.add("/lostPwdPersonSubmitApp");
		
		listPublicAll.add("TimeRegionUsed");	//TODO 不知道作用，暂时放着
		
		listPublicAll.add("/app/");											//app接口
		listPublicAll.add("/power/getButtonList.action");
		listPublicAll.add("/verifyCode");
		listPublicAll.add("/js/");												//js文件夹
		listPublicAll.add("/css/");												//css文件夹
		listPublicAll.add("/images/");											//图片文件夹
		listPublicAll.add("/bootstrap");										//bootstrap文件夹
		listPublicAll.add("/bootstrap-table");									//bootstrap-table文件夹
		listPublicAll.add("/dist");												//dist文件夹
		listPublicAll.add("/html");												//html文件夹
		listPublicAll.add("/sass");												//sass文件夹
		listPublicAll.add(".exe");												//.exe执行程序
		listPublicAll.add("/agreement.html");									//协议文件
		listPublicAll.add("/404.jsp");									//404错误跳转
		listPublicAll.add("/500.jsp");									//500错误跳转
 		listPublicAll.add("/resources/");									//
 		listPublicAll.add("/swagger");									//swagger
 		listPublicAll.add("/v2/api");
 		listPublicAll.add("/doc.html");
 		listPublicAll.add("/webjars/");	
 		
 		listPublicAll.add("/workflow/public");									//F2手机签名等

 		listPublicAll.add("/app/processImg/viewMissDinnerApplyProImg");//流程图查看放行
        listPublicAll.add("/workflow/flowDesigner/workflowMap");//流程图查看放行

		List<String> listPublicMobile=new ArrayList<>();
		powerMap.put(PUBLIC_MOBILE,listPublicMobile);
		
		
		List<String> listPublicPC=new ArrayList<>();
		powerMap.put(PUBLIC_PC,listPublicPC);
		
	}
	
	public static boolean ifFilter(String path,String powerType){
		if(StringUtils.isNotBlank(path)){
			List<String> powerList=powerMap.get(powerType);
			for(String power:powerList){
				if(path.contains(power)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	// \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),    
    // 字符串在编译时会被转码一次,所以是 "\\b"    
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)    
   private  static  String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"    
            +"|windows (phone|ce)|blackberry"    
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"    
            +"|laystation portable)|nokia|fennec|htc[-_]"    
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    
   private  static  String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"    
            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    
      
    //移动设备正则匹配：手机端、平板  
   private  static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);    
   private  static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);    
    
   /**
    * 检测是否是移动设备访问
    * @return
    */
    public static boolean check(String userAgent){    
        if(null == userAgent){    
            userAgent = "";    
        }    
        // 匹配    
        Matcher matcherPhone = phonePat.matcher(userAgent);    
        Matcher matcherTable = tablePat.matcher(userAgent);    
        if(matcherPhone.find() || matcherTable.find()){    
            return true;    
        } else {    
            return false;    
        }    
    }
    
   
	/**
	 * 判断是否为app设备
	 */
	public boolean isAppDevice(HttpServletRequest request){
		String ua = request.getHeader("User-Agent");
		ua = ua.substring(ua.lastIndexOf("/")+1, ua.length());
		String[] cus = ua.split("_");
		if(cus.length>1&&("android".equals(cus[0])||"ios".equals(cus[0]))){
			return true;
		}else{
			return false;
		}
	}
	
    /**
	 * 获取访问端(-1:访问出错,0:PC段,1:移动端)
	 */ 
	public static String chekcVisitClient(HttpServletRequest req, HttpServletResponse resp){
		try {
			String userAgent=req.getHeader("user-agent");
			if(StringUtils.isBlank(userAgent)){
				return UNKNOWN;
			}
			if(FilterHelper.check(userAgent)){
				return APP;
			}else{
				return PC;
			}
		} catch (Exception e) {
			return UNKNOWN;
		}
	}
	
	public static boolean isAjax(HttpServletRequest request) {
        return StringUtils.isNotEmpty(request.getHeader(X_REQUESTED_WITH)) &&
        		XML_HTTP_REQUEST.equalsIgnoreCase(request.getHeader(X_REQUESTED_WITH));
    }
}
