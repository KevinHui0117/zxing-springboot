package com.zgh.xxg.xxg.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

public class Tools {

	 
	
	public static String getCurrentTime(String type){
		String formate="yyyyMMddHHmmss";
		switch (type) {
		case "1":
			formate = "yyyyMMddHHmmss";
			break;
		case "2":
			formate = "yyyy-MM-dd HH:mm:ss";
			break;
		case "3":
			formate = "yyyy-MM-dd";
			break;
		case "4":
			formate = "yyyyMMdd";
			break;
		default:
			formate = "yyyyMMddHHmmss";
		}
		Date date=new Date();
		DateFormat format=new SimpleDateFormat(formate);
		String time=format.format(date);
		return time;
	}

	public static String getUUID() {
//		return UUID.randomUUID().toString().replace("-", "");
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;
	}

	
	 public static boolean isOSLinux() {
        Properties prop = System.getProperties();

        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
            return true;
        } else {
            return false;
        }
	 }
	
	
	
	public static void main(String[] args) {
		 String str = "男#女";
		 String str2 = "boy#girl";
		 String[] strArr = str.split("#");
		 
		 System.out.println(str.split("#").length);
		 System.out.println(str2.split("#").length);

        System.out.println(Tools.getUUID());
	}
}
