package com.zgh.xxg.xxg.base.service;



import com.zgh.xxg.xxg.base.module.Operater;
import com.zgh.xxg.xxg.base.module.Page;
import com.zgh.xxg.xxg.base.module.PageData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface IBaseService<T,K>  {

	T insert(T entity, Operater operater);
	int insertReturnKey(T entity, Operater operater);
	T insertNoLog(T entity, Operater operater);
	List<T>  insertList(List<T> list, Operater operater);
	List<T>  insertListNoLog(List<T> list, Operater operater);
	
	int delete(K id, Operater operater);
	int deleteNoLog(K id, Operater operater);
	int delete(Map<String, Object> params, Operater operater);
	int deleteNoLog(Map<String, Object> params, Operater operater);
	
	int update(T entity, Operater operater);
	int updateNoLog(T entity, Operater operater);
	int updateFields(Map<String, Object> params, T entity, Operater operater);
	int updateFieldsNoLog(Map<String, Object> params, T entity, Operater operater);
    int updateParamsNoFormToken(Map<String, Object> params);

	T get(K id);
    K getParams();
    K getData(T params);
	T getSingle(Map<String, Object> params);
	
	
	HashMap getMap(K id);
	List<HashMap> listMapByParams(Map<String, Object> params);
	
	List<T> list(Map<String, Object> params, PageData pageData);
	int count(Map<String, Object> params);
	
	String getNextSeq();

	//显示页数
	Page showPage(Page page);

	Page queryPage(Page page);

    void setUpdateParams(Map<String, Object> params, Operater operater);

}
