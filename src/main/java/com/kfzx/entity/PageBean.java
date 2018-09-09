package com.kfzx.entity;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
public class PageBean {
	/**
	 * 第几页
	 */
	private int page;
	private int pageSize; // 每页记录数
	private int start;  // 起始页


	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

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
		//100  200
		return (page - 1) * pageSize;
	}
}
