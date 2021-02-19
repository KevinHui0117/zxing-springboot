package com.zgh.xxg.xxg.util;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * select编造类
 * @author YXY
 *
 */
public class SelectMaker {
	
	/**
	 * 证件类型 options 编造
	 * @param model
	 */
	public static void identityTypeOptionsMaker(Model model) {
		List<HashMap<String, String>> identityTypeOptions = new ArrayList<HashMap<String, String>>();
		Map identityTypeOption0 = new HashMap();
		identityTypeOption0.put("id", "0");
		identityTypeOption0.put("value", "身份证");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption0);
		Map identityTypeOption1 = new HashMap();
		identityTypeOption1.put("id", "1");
		identityTypeOption1.put("value", "军官证");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption1);
		Map identityTypeOption2 = new HashMap();
		identityTypeOption2.put("id", "2");
		identityTypeOption2.put("value", "回乡证");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption2);
		Map identityTypeOption3 = new HashMap();
		identityTypeOption3.put("id", "3");
		identityTypeOption3.put("value", "台胞证");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption3);
		Map identityTypeOption4 = new HashMap();
		identityTypeOption4.put("id", "4");
		identityTypeOption4.put("value", "护照");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption4);
		Map identityTypeOption5 = new HashMap();
		identityTypeOption5.put("id", "5");
		identityTypeOption5.put("value", "其他");
		identityTypeOptions.add((HashMap<String, String>) identityTypeOption5);
		model.addAttribute("identityTypeOptions", identityTypeOptions);
	}
	/**
	 * 性别 options 编造
	 * @param model
	 */
	public static void genderOptionMaker(Model model) {
		List<HashMap<String, String>> genderOptions = new ArrayList<HashMap<String, String>>();
		Map genderOption0 = new HashMap();
		genderOption0.put("id", "0");
		genderOption0.put("value", "男");
		genderOptions.add((HashMap<String, String>) genderOption0);
		Map genderOption1 = new HashMap();
		genderOption1.put("id", "1");
		genderOption1.put("value", "女");
		genderOptions.add((HashMap<String, String>) genderOption1);
		model.addAttribute("genderOptions", genderOptions);
	}
	/**
	 * 政治面貌 options 编造
	 * @param model
	 */
	public static void politicsOptionMaker(Model model) {
		List<HashMap<String, String>> politicsOptions = new ArrayList<HashMap<String, String>>();
		Map politicsOption0 = new HashMap();
		politicsOption0.put("id", "0");
		politicsOption0.put("value", "中共党员");
		politicsOptions.add((HashMap<String, String>) politicsOption0);
		Map politicsOption1 = new HashMap();
		politicsOption1.put("id", "1");
		politicsOption1.put("value", "预备党员");
		politicsOptions.add((HashMap<String, String>) politicsOption1);
		Map politicsOption2 = new HashMap();
		politicsOption2.put("id", "2");
		politicsOption2.put("value", "共青团员");
		politicsOptions.add((HashMap<String, String>) politicsOption2);
		Map politicsOption3 = new HashMap();
		politicsOption3.put("id", "3");
		politicsOption3.put("value", "群众");
		politicsOptions.add((HashMap<String, String>) politicsOption3);
		Map politicsOption4 = new HashMap();
		politicsOption4.put("id", "4");
		politicsOption4.put("value", "其他");
		politicsOptions.add((HashMap<String, String>) politicsOption4);
		model.addAttribute("politicsOptions", politicsOptions);
	}
	/**
	 * 探亲假类型  options 编造
	 * @param model
	 */
	public static void FamilyVacationOptionMaker(Model model) {
		List<HashMap<String, String>> FamilyVacationOptions = new ArrayList<HashMap<String, String>>();
		Map FamilyVacationOption0 = new HashMap();
		FamilyVacationOption0.put("id", "0");
		FamilyVacationOption0.put("value", "无");
		FamilyVacationOptions.add((HashMap<String, String>) FamilyVacationOption0);
		Map FamilyVacationOption1 = new HashMap();
		FamilyVacationOption1.put("id", "1");
		FamilyVacationOption1.put("value", "父母");
		FamilyVacationOptions.add((HashMap<String, String>) FamilyVacationOption1);
		Map FamilyVacationOption2 = new HashMap();
		FamilyVacationOption2.put("id", "2");
		FamilyVacationOption2.put("value", "配偶");
		FamilyVacationOptions.add((HashMap<String, String>) FamilyVacationOption2);
		model.addAttribute("FamilyVacationOptions", FamilyVacationOptions);
	}
	/**
	 * 人员类型  options 编造
	 * @param model
	 */
	public static void personTypeMaker(Model model) {
		List<HashMap<String, String>> personTypeOptions = new ArrayList<HashMap<String, String>>();
		Map personTypeOption0 = new HashMap();
		personTypeOption0.put("id", "0");
		personTypeOption0.put("value", "普通工作人员");
		personTypeOptions.add((HashMap<String, String>) personTypeOption0);
		Map personTypeOption1 = new HashMap();
		personTypeOption1.put("id", "1");
		personTypeOption1.put("value", "专干");
		personTypeOptions.add((HashMap<String, String>) personTypeOption1);
		model.addAttribute("personTypeOptions", personTypeOptions);
	}
	/**
	 * 独生子女护理假  options 编造
	 * @param model
	 */
	public static void isOnlyChildOptionMaker(Model model) {
		List<HashMap<String, String>> isOnlyChildOptions = new ArrayList<HashMap<String, String>>();
		Map isOnlyChildOption0 = new HashMap();
		isOnlyChildOption0.put("id", "0");
		isOnlyChildOption0.put("value", "无");
		isOnlyChildOptions.add((HashMap<String, String>) isOnlyChildOption0);
		Map isOnlyChildOption1 = new HashMap();
		isOnlyChildOption1.put("id", "1");
		isOnlyChildOption1.put("value", "有");
		isOnlyChildOptions.add((HashMap<String, String>) isOnlyChildOption1);
		model.addAttribute("isOnlyChildOptions", isOnlyChildOptions);
	}
	
	/**
	 * 机构类型 options 编造
	 * @param model
	 */
	public static void orgTypeOptionMaker(Model model){
	List<HashMap<String,String>> orgTypeOptions = new ArrayList<HashMap<String,String>>();
	Map orgTypeOption1 =new HashMap();
	orgTypeOption1.put("id", "0");orgTypeOption1.put("value", "基层以上工会");
	orgTypeOptions.add((HashMap<String, String>) orgTypeOption1);
	Map orgTypeOption2 =new HashMap();
	orgTypeOption2.put("id", "1");orgTypeOption2.put("value", "单独基层工会");
	orgTypeOptions.add((HashMap<String, String>) orgTypeOption2);
	model.addAttribute("orgTypeOptions",orgTypeOptions);
	}
	
	/**
	 * 是否是服务站  options 编造
	 * @param model
	 */
	public static void  IsServerstationOption(Model model){
	List<HashMap<String,String>> IsServerstationOptions = new ArrayList<HashMap<String,String>>();
	Map IsServerstationOption1 =new HashMap();
	IsServerstationOption1.put("id", "0");IsServerstationOption1.put("value", "否");
	IsServerstationOptions.add((HashMap<String, String>) IsServerstationOption1);
	Map IsServerstationOption2 =new HashMap();
	IsServerstationOption2.put("id", "1");IsServerstationOption2.put("value", "是");
	IsServerstationOptions.add((HashMap<String, String>) IsServerstationOption2);
	model.addAttribute("IsServerstationOptions",IsServerstationOptions);
	}
}
