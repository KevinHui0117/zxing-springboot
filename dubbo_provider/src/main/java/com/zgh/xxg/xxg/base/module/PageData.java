package com.zgh.xxg.xxg.base.module;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;


@Alias(value="PageData")
public class PageData implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int MAX_PAGE_SIZE=50000;
	private int totalSize;
	private int pageSize;
	private int currentPage;
	private int totalPage = 0;
	private int page;
	private int rows;
	private int limit;
	private int offset;
	
	/**
	 * 构造方法，默认每页为15条记录，显示第一页
	 */
	public PageData(){
		pageSize = 15;
		currentPage = 1;
	}
	public int getTotalPage() {
		if(pageSize != 0){
			totalPage=(totalSize+pageSize-1)/pageSize;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		if(pageSize <= 0)
			pageSize = 15;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize > MAX_PAGE_SIZE){
			throw new RuntimeException("每页数据最多为"+MAX_PAGE_SIZE+"条，请重新设置");
		}
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		if(currentPage == 0)
			currentPage = 1;
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		this.currentPage = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.pageSize = rows;
		this.rows = rows;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.pageSize = limit;
		this.limit = limit;
		init_currentPage();
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
		init_currentPage();
	}

	private void init_currentPage() {
		if(this.limit==0){
			return;
		}
		this.currentPage = this.offset/this.limit+1;
	}
}
