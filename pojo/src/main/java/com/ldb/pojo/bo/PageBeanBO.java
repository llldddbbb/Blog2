package com.ldb.pojo.bo;

public class PageBeanBO {
	
	private int page;
	private int pageSize;
	private int start;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return (page-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public PageBeanBO() {
		super();
	}
	public PageBeanBO(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	
}
