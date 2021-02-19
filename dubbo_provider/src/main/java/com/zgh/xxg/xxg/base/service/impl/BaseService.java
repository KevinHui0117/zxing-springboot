package com.zgh.xxg.xxg.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.zgh.xxg.xxg.app.model.ResultStatus;
import com.zgh.xxg.xxg.base.annotation.PrimaryKey;
import com.zgh.xxg.xxg.base.dao.IBaseDao;
import com.zgh.xxg.xxg.base.module.*;
import com.zgh.xxg.xxg.base.service.IBaseService;
import com.zgh.xxg.xxg.util.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T,K> implements IBaseService<T, K> {

	public static final String IF_RECORD_OPERATELOG_DETAIL="ifRecordOperateLogDetail";
	public static final int SUC_CODE = ResultStatus.SUCCESS.getCode();
	public static final int FAIL_CODE = ResultStatus.FAIL.getCode();

	
	@Autowired
	protected SqlSession sqlSession;
	
	public abstract String getOperateModule();
	public abstract String getOperateSubModule();
	public abstract String getOperateData();

    @Autowired
    private IBaseDao<T, K> baseDao;

	public IBaseDao<T, K> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T, K> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	@Transactional
	public T insert(T entity, Operater operater) {
		if(entity==null){
			return entity;
		}
		entity=insertNoLog(entity, operater);
		saveOperateLog(OperateLog.LOG_TYPE_INSERT, JSON.toJSONString(entity), SystemConstant.SUCCESS_STRING, "1", null, null, operater);
		if(SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
			OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),OperateLog.LOG_TYPE_INSERT, entity,operater);
		}
		return entity;
	}

	@Override
	@Transactional
	public int insertReturnKey(T entity, Operater operater) {
		if(entity==null){
			return FAIL_CODE;
		}
		entity=insertNoLog(entity, operater);
		saveOperateLog(OperateLog.LOG_TYPE_INSERT, JSON.toJSONString(entity), SystemConstant.SUCCESS_STRING, "1", null, null, operater);
		if(SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
			OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),OperateLog.LOG_TYPE_INSERT, entity,operater);
		}
		return SUC_CODE;
	}
	
	@Override
	@Transactional
	public T insertNoLog(T entity,Operater operater) {
		if(entity==null){
			return entity;
		}
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			be.setCreateName(operater==null?"":operater.getFullName());
			be.setCreater(operater==null?0L:operater.getUserId());
			if(StringUtils.isBlank(be.getCreateTime())){
				be.setCreateTime(TimeUtil.getCurrentDateTime());
			}
		}
		baseDao.insert(entity);
		return entity;
	}

	@Override
	@Transactional
	public List<T>  insertList(List<T> list,Operater operater) {
		if(list==null || list.isEmpty()){
			return list;
		}
		list=insertListNoLog(list, operater);
		saveOperateLog(OperateLog.LOG_TYPE_INSERT, JSON.toJSONString(list), SystemConstant.SUCCESS_STRING, list.size()+"", null, null, operater);
		if(SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
			OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),OperateLog.LOG_TYPE_INSERT, list,operater);
		}
		return  list;
	}
	
	
	@Override
	@Transactional
	public List<T>  insertListNoLog(List<T> list,Operater operater) {
		if(list==null || list.isEmpty()){
			return list;
		}
		baseDao.insertList(list);
		return  list;
	}

	@Override
	@Transactional
	public int delete(K id,Operater operater) {
		if(id==null){
			return 0;
		}
		T oldObj = baseDao.get(id);
		if(oldObj==null){
			return 0;
		}
		int n=baseDao.delete(id);
		if(n!=0){
			saveOperateLog(OperateLog.LOG_TYPE_DELETE, id.toString(), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
			if(SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
				OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),OperateLog.LOG_TYPE_DELETE, oldObj,operater);
				
			}
		}
		return n;
	}
		
	@Override
	@Transactional
	public int deleteNoLog(K id,Operater operater) {
		if(id==null){
			return 0;
		}
		T oldObj = baseDao.get(id);
		if(oldObj==null){
			return 0;
		}
		int n=baseDao.delete(id);
		return n;
	}
	

	@Override
	@Transactional
	public int delete(Map<String, Object> params,Operater operater) {
		if(params.isEmpty()){
			return 0;
		}
		T oldObj = baseDao.getSingle(params);
		if(oldObj==null){
			return 0;
		}
		int n=baseDao.deleteMap(params);
		if(n!=0){
			saveOperateLog(OperateLog.LOG_TYPE_DELETE, params.toString(), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
			if(SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
				OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),OperateLog.LOG_TYPE_DELETE, oldObj,operater);
			}
		}
		return n;
	}
	
	@Override
	@Transactional
	public int deleteNoLog(Map<String, Object> params,Operater operater) {
		if(params.isEmpty()){
			return 0;
		}
		T oldObj = baseDao.getSingle(params);
		if(oldObj==null){
			return 0;
		}
		int n=baseDao.deleteMap(params);
		return n;
	}
	
	
	@Override
	@Transactional
	public int update(T entity,Operater operater) {
		if(entity==null){
			return 0;
		}
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			be.setUpdateName(operater==null?"":operater.getFullName());
			be.setUpdater(operater==null?0L:operater.getUserId());
			be.setUpdateTime(TimeUtil.getCurrentDateTime());
		}

		//不需要详细日志，只记录操作操作日志，不需要获取oldObj
		if(!SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
			int n=baseDao.update(entity); 
			if(n!=0){
				saveOperateLog(OperateLog.LOG_TYPE_UPDATE, JSON.toJSONString(entity), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
			}
			return n;
		}
		
		
		Field idField = null;
		
		T oldObj =null;
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			oldObj=baseDao.get((K)(be.getId()));
		}else{
			Class clazz=entity.getClass();
			Field[] fields = clazz.getDeclaredFields();
			// 遍历实体字段，找到主键字段
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
			try {
				oldObj = baseDao.get((K)idField.get(entity));
			} catch (IllegalArgumentException e) {
	
			} catch (IllegalAccessException e) {
		
			}
		}
		
		//更新数据
		int n=baseDao.update(entity);
		
		
		T newObj=null;
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			newObj=baseDao.get((K)(be.getId()));
		}else{
			try {
				newObj=baseDao.get((K)idField.get(entity));
			} catch (IllegalArgumentException e) {
		
			} catch (IllegalAccessException e) {
	
			}
		}
		
		//记录日志
		if(n!=0){
			OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),oldObj, newObj,operater);
			saveOperateLog(OperateLog.LOG_TYPE_UPDATE, JSON.toJSONString(entity), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
		}
		
		return n;
	}

	
	@Override
	@Transactional
	public int updateNoLog(T entity,Operater operater) {
		if(entity==null){
			return 0;
		}
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			be.setUpdateName(operater==null?"":operater.getFullName());
			be.setUpdater(operater==null?0L:operater.getUserId());
			be.setUpdateTime(TimeUtil.getCurrentDateTime());
		}
		return baseDao.update(entity);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateParamsNoFormToken(Map<String, Object> params) {

        if(params==null || params.isEmpty()){
            return 0;
        }

        //清除formToken
        params.remove("formToken");

        //更新数据
        int n=baseDao.updateFields(params);

        //TODO 日志

        return n;

    }

    @Override
    public void setUpdateParams(Map<String, Object> params,Operater operater) {
        params.put("updateName", operater==null?"":operater.getFullName());
        params.put("updater", operater==null?0L:operater.getUserId());
        params.put("updateTime", TimeUtil.getCurrentDateTime()); 
    }

    @Override
	@Transactional
	public int updateFields(Map<String, Object> params,T entity,Operater operater) {
		if(params==null || params.isEmpty() || entity==null){
			return 0;
		}

		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
            setUpdateParams(params,operater);
		}
		
		if(!SystemConstant.YES_STRING.equals(SystemProperty.getProperty(IF_RECORD_OPERATELOG_DETAIL))){
			int n= baseDao.updateFields(params);
			if(n!=0){
				saveOperateLog(OperateLog.LOG_TYPE_UPDATE, JSON.toJSONString(params), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
			}
			return n;
		}
		
		Field idField = null;
		
		T oldObj =null;
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			oldObj=baseDao.get((K)(be.getId()));
		}else{
			Class clazz=entity.getClass();
			Field[] fields = clazz.getDeclaredFields();
			// 遍历实体字段，找到主键字段
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
			try {
				oldObj = baseDao.get((K)idField.get(entity));
			} catch (IllegalArgumentException e) {
	
			} catch (IllegalAccessException e) {
		
			}
		}
		
		//更新数据
		int n=baseDao.updateFields(params);
		
		
		T newObj=null;
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
			newObj=baseDao.get((K)(be.getId()));
		}else{
			try {
				newObj=baseDao.get((K)idField.get(entity));
			} catch (IllegalArgumentException e) {
		
			} catch (IllegalAccessException e) {
	
			}
		}
		
		//记录日志
		if(n!=0){
			saveOperateLog(OperateLog.LOG_TYPE_UPDATE, JSON.toJSONString(params), SystemConstant.SUCCESS_STRING, n+"", null,null, operater);
			OperateLogDetailUtil.saveOperateLogDetail(sqlSession.getConnection(),oldObj, newObj,operater);
		}
		
		return n;
	}
	
	
	@Override
	@Transactional
	public int updateFieldsNoLog(Map<String, Object> params,T entity,Operater operater) {
		if(params==null || params.isEmpty() || entity==null){
			return 0;
		}
		
		if(entity instanceof BaseEntity){
			BaseEntity be=(BaseEntity)entity;
            setUpdateParams(params,operater);
		}
		
		int n= baseDao.updateFields(params);
		return n;
	
	}
	
	@Override
	public HashMap getMap(K id) {
		return baseDao.getMap(id);
	}

	@Override
	public T get(K id) {
		return baseDao.get(id);
	}


    @Override
    public K getParams() {
        return baseDao.getParams();
    }

    @Override
    public K getData(T params) {
        return baseDao.getData(params);
    }

    @Override
	public T getSingle(Map<String, Object> params) {
		return baseDao.getSingle(params);
	}
	
	@Override
	public List<HashMap> listMapByParams(Map<String, Object> params) {
		return baseDao.listMapByParams(params);
	}
	
	@Override
	public List<T>  list(Map<String, Object> params,
			PageData pageData) {
		if(pageData==null){
			pageData=new PageData();
		}
		if(params==null){
			params=new HashMap<String, Object>();
		}
		
		params.put("pageData", pageData);
		
		return baseDao.list(params);
	}

	@Override
	public int count(Map<String, Object> params) {
		return baseDao.count(params);
	}
	
	@Override
	public String getNextSeq() {
		return baseDao.getNextSeq();
	}
	
	protected  void saveOperateLog(OperateLog log,Operater operater) {
		OperateLogUtil.saveOperateLog(sqlSession.getConnection(), log,operater);
	}
	
	protected void saveOperateLog(OperateLog log) {
		OperateLogUtil.saveOperateLog(sqlSession.getConnection(), log);
	}
	
	protected void saveOperateLog(String logType,String operateParam,String operateStatus,String operateResult,String errorMessage,String note,
			Operater operater) {
		OperateLog log=new OperateLog();
		log.setLogType(logType);
		log.setOperateModule(getOperateModule());
		log.setOperateSubModule(getOperateSubModule());
		log.setOperateData(getOperateData());
		log.setOperateParam(operateParam);
		log.setOperateStatus(operateStatus);
		log.setOperateResult(operateResult);
		log.setErrorMessage(errorMessage);
		log.setNote(note);
		log.setDataCode(operater==null?"":operater.getUserDataCode());
		OperateLogUtil.saveOperateLog(sqlSession.getConnection(), log,operater);
	}

	//显示分页
	public Page showPage(Page page){
		page.setTotal(baseDao.count(page.getMap()));
		PageData pageData=new PageData();
		pageData.setCurrentPage(page.getPageNo());
		pageData.setPageSize(page.getPageSize());
		page.getMap().put("pageData", pageData);
		page.setRows(baseDao.list(page.getMap()));
		page.getMap().remove("pageData");
		return page;
	}


	public Page queryPage(Page page){
		page.setTotal(baseDao.countInt(page));
		page.setRows(baseDao.selectList(page));
		return page;
	}

}
