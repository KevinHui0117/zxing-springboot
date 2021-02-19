package com.zgh.xxg.xxg.util;


import com.zgh.xxg.xxg.base.module.BaseEntity;
import com.zgh.xxg.xxg.base.module.Operater;
import org.apache.commons.lang3.StringUtils;

//设置表数据权限的字段
public class DataCodeUntil {

    //数据插入设置
    public static void insertSet(Operater operater, BaseEntity baseEntity) {
    	if(StringUtils.isBlank(baseEntity.getDataCode())){
    		baseEntity.setDataCode(operater.getUserDataCode());
    	}
        baseEntity.setCreater(operater.getUserId());
        baseEntity.setCreateName(operater.getFullName());
        baseEntity.setCreateTime(OADateUtil.getCurrentDateTime());
        baseEntity.setUpdateTime(OADateUtil.getCurrentDateTime());
    }

    //数据修改设置
    public static void updateSet(Operater operater, BaseEntity baseEntity){
    	if(StringUtils.isBlank(baseEntity.getDataCode())){
    		baseEntity.setDataCode(operater.getUserDataCode());
    	}
        baseEntity.setUpdater(operater.getUserId());
        baseEntity.setUpdateName(operater.getFullName());
        baseEntity.setUpdateTime(OADateUtil.getCurrentDateTime());
    }
}
