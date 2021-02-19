package com.zgh.xxg.xxg.base.dao;

import com.zgh.xxg.xxg.base.module.Page;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface IBaseDao<T,K> {

	void insert(T entity);
	int insertReturnKey(T entity);
	int insertList(List<T> list);
	
	int delete(K id);
	int deleteMap(Map<String, Object> params);
	
	int update(T entity);
	int updateFields(@Param("params") Map<String, Object> params);
	
	T get(K id);
    K getParams();
    K getData(T params);
	T getSingle(Map<String, Object> params);
	
	List<T> list(Map<String, Object> params);
	int count(Map<String, Object> params);
	
	HashMap getMap(K id);
	List<HashMap> listMapByParams(Map<String, Object> params);
	
	String getNextSeq();

	int countInt(Page page);

	List<T> selectList(Page page);

}
