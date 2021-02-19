package com.zgh.xxg.xxg.util;

import com.zgh.xxg.xxg.base.annotation.FieldAlias;
import com.zgh.xxg.xxg.base.annotation.IgnoreField;
import com.zgh.xxg.xxg.base.annotation.PrimaryKey;
import com.zgh.xxg.xxg.base.module.BaseEntity;
import com.zgh.xxg.xxg.base.module.OperateLog;
import com.zgh.xxg.xxg.base.module.OperateLogDetail;
import com.zgh.xxg.xxg.base.module.Operater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperateLogDetailUtil  {
	
	private static final Logger logger= LoggerFactory.getLogger(OperateLogDetailUtil.class);
	
	public static <T> void saveOperateLogDetail(Connection conn, T oldObj, T newObj, Operater operater){
				// 如果两个对象相同直接退出
				if (oldObj == newObj) {
					return ;
				}
				List<OperateLogDetail> list = new ArrayList<OperateLogDetail>();
				Class clazz=oldObj.getClass();
				Field[] fields = clazz.getDeclaredFields();
				List<Field> allFields = new ArrayList<Field>();
				Field idField = null;

				// 遍历实体字段
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.getName().equals("id")) {
						idField = field;
					}
					if (field.isAnnotationPresent(PrimaryKey.class)) {
						idField = field;
					}
					// 去除不记录变更的注解字段，添加所有变更字段.
					if (!field.isAnnotationPresent(IgnoreField.class)) {
						 if (field.getGenericType().toString().startsWith(  //只记录基本类型和字符串，对其他类型不记录
			                        "class java.lang.")  || !field.getGenericType().toString().startsWith("class") ){
							 allFields.add(field);
						 } 
					}
				}

				// 比较实体对象的属性值，若修改了则记录变更历史
				for (Field field : allFields) {
					field.setAccessible(true);
					field.getAnnotation(FieldAlias.class);
					try {
						if ((field.get(oldObj) != null ^ field.get(newObj) != null) 
						    || (field.get(oldObj)!=null && field.get(newObj) !=null &&(!field.get(oldObj).equals(field.get(newObj))))) {
							OperateLogDetail operateLogDetail = new OperateLogDetail();
							operateLogDetail.setOperateType(OperateLog.LOG_TYPE_UPDATE);
							operateLogDetail.setEntity(clazz.toString().substring(6));
							operateLogDetail.setFieldName(field.getName());
							if (field.isAnnotationPresent(FieldAlias.class)) {
								operateLogDetail.setFieldAlias(field.getAnnotation(FieldAlias.class).alias());
							}
							operateLogDetail.setOldValue(field.get(oldObj)==null?null:String.valueOf(field.get(oldObj)));
							operateLogDetail.setNewValue(field.get(newObj)==null?null:String.valueOf(field.get(newObj)));
							
							// 记录修改的对象的主键Id
							if(oldObj instanceof BaseEntity){
								BaseEntity be=(BaseEntity)oldObj;
								operateLogDetail.setPrimaryKeyValue(be.getId().toString());
								operateLogDetail.setPrimaryKeyName("id");
							}else if (idField != null) {
								operateLogDetail.setPrimaryKeyValue(idField.get(oldObj)==null?null:idField.get(oldObj).toString());
								operateLogDetail.setPrimaryKeyName(idField.getName());
							}
							
							if(operater!=null){
								operateLogDetail.setOperaterId(operater.getUserId());
								operateLogDetail.setOperaterName(operater.getFullName());
								operateLogDetail.setOperaterIp(operater.getIp());
								operateLogDetail.setBusinessCode(operater.getBusinessCode());
								operateLogDetail.setDataCode(operater.getUserDataCode());
							}
							list.add(operateLogDetail);
						}
					} catch (IllegalArgumentException ex) {
						logger.error("记录详细操作日志出错",ex);
						return;
					} catch (IllegalAccessException ex) {
						logger.error("记录详细操作日志出错",ex);
						return;
					}
				}
				save(conn,list);
				
	}
	
	public static <T> void saveOperateLogDetail(Connection conn,String action, T entity,Operater  operater) {
		Class clazz=entity.getClass();
		OperateLogDetail operateLogDetail = new OperateLogDetail();
		operateLogDetail.setEntity(clazz.toString().substring(6));
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			operateLogDetail.setPrimaryKeyValue(be.getId().toString());
			operateLogDetail.setPrimaryKeyName("id");
		}else{
				Field[] fields = clazz.getDeclaredFields();
				Field idField = null;
				// 遍历实体字段
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.getName().equals("id")) {
						idField = field;
					}
					if (field.isAnnotationPresent(PrimaryKey.class)) {
						idField = field;
					}
					if(idField!=null){
						break;
					}
				}
				if (idField != null) {
					try {
						operateLogDetail.setPrimaryKeyValue(idField.get(entity)==null?null:idField.get(entity).toString());
					} catch (IllegalArgumentException ex) {
						logger.error("记录详细操作日志出错",ex);
						return;
					} catch (IllegalAccessException ex) {
						logger.error("记录详细操作日志出错",ex);
						return;
					}
					operateLogDetail.setPrimaryKeyName(idField.getName());
				}
		}
		
		operateLogDetail.setOperateType(action);
		if(operater!=null){
			operateLogDetail.setOperaterId(operater.getUserId());
			operateLogDetail.setOperaterName(operater.getFullName());
			operateLogDetail.setOperaterIp(operater.getIp());
			operateLogDetail.setBusinessCode(operater.getBusinessCode());
			operateLogDetail.setDataCode(operater.getUserDataCode());
		}
		List<OperateLogDetail> list = new ArrayList<OperateLogDetail>();
		list.add(operateLogDetail);
		save(conn,list);
	}
	
	public static <T> void saveOperateLogDetail(Connection conn,String action, List<T> entitys,Operater operater) {
		if(entitys==null || entitys.isEmpty()){
			return;
		}
		for(T t:entitys){
			saveOperateLogDetail(conn,action, t, operater);
		}
	}
	
	private static void save(Connection conn,List<OperateLogDetail> list){
		if(list==null || list.isEmpty()){
			return;
		}
		PreparedStatement	ps=null;
		try{
			ps=conn.prepareStatement("INSERT INTO tlog_detail (id,entity,operateType,primaryKeyName,primaryKeyValue,fieldName,fieldAlias,oldValue,newValue,operaterId,operaterName,operaterIp,operateTime,businessCode,dataCode) VALUES (seq_tlog_detail.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for(OperateLogDetail operateLogDetail:list){
				ps.setString(1, operateLogDetail.getEntity());
				ps.setString(2, operateLogDetail.getOperateType());
				ps.setString(3, operateLogDetail.getPrimaryKeyName());
				ps.setString(4, operateLogDetail.getPrimaryKeyValue());
				ps.setString(5, operateLogDetail.getFieldName());
				ps.setString(6, operateLogDetail.getFieldAlias());
				ps.setString(7, operateLogDetail.getOldValue());
				ps.setString(8, operateLogDetail.getNewValue());
				ps.setLong(9, operateLogDetail.getOperaterId());
				ps.setString(10, operateLogDetail.getOperaterName());
				ps.setString(11, operateLogDetail.getOperaterIp());
				ps.setString(12, TimeUtil.getCurrentDateTime());
				ps.setString(13, operateLogDetail.getBusinessCode());
				ps.setString(14,operateLogDetail.getDataCode());
				ps.addBatch();
			}
			ps.executeBatch();
		}catch(SQLException ex){
			logger.error("记录详细操作日志出错",ex);
			return;
		}finally{
			if(ps!=null){
				try{ps.close();}catch(Exception ex){}
			}
		}
	}
	
}



