package com.zgh.xxg.xxg.base.module;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

    private int total;//总条数
    private int pageNo = 1;//当前页，默认第一页
    private int pageSize = 10;//页大小，默认10条
    private List<T> rows;//查询结果
    public Map<String, Object> map = new HashMap<String, Object>();//查询条件
    public int rowEnd;//分页结束数
    public int rowStart;//分页起始数

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        int totalPage = total%pageSize>0 ? total/pageSize+1 : total/pageSize;
        if(totalPage < pageNo){
            pageNo = totalPage;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        if (pageNo != null && !"".equals(pageNo)) {
            this.pageNo = Integer.valueOf(pageNo);
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        if (pageSize != null && !"".equals(pageSize)) {
            this.pageSize = Integer.valueOf(pageSize.trim());
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    //分页结束数
    public int getRowEnd() {
        int rowend = pageNo * pageSize;
        return rowend;
    }

    //分页起始数
    public int getRowStart() {
        int rowstart = (pageNo - 1) * pageSize + 1;
        return rowstart;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void putCondition(String key,Object value) {
        map.put(key,value);
    }

    public void clearCondition(){
        map.clear();
    }
}
