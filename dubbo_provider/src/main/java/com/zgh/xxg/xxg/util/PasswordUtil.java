package com.zgh.xxg.xxg.util;

public class PasswordUtil {

	private static final String PASSWORD_NUMBER="23456789";
	private static final String PASSWORD_CHAR="abcdefghjkmnpqrstuwxyABCDEFGHJKMNPQRSTUWXY";
	
	public static String getRandomPassword(int pwdLength){
		StringBuilder sb=new StringBuilder();
		 while(sb.length()<pwdLength){
			 int n=(int)(Math.random()*100);
			 if(n%4==0){
				 sb.append(PASSWORD_NUMBER.charAt((int)(Math.random()*PASSWORD_NUMBER.length())));
			 }else{
				 sb.append(PASSWORD_CHAR.charAt((int)(Math.random()*PASSWORD_CHAR.length())));
			 }
		 }
		 return sb.toString();
	}
	
	public static String getRandomPassword(){
		return getRandomPassword(8);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<=10;i++){
				System.out.println(getRandomPassword());
		}
	}
}
