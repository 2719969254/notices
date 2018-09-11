package com.kfzx.entity;

import java.util.Date;

/**
 * 友情链接
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public class Link {
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 链接名称
	 */
	private String name;
	/**
	 * 链接地址
	 */
	private String url;
	private Integer isUse;
	/**
	 * 排序序号 从小到大排序
	 */
	private Integer orderNo;
	private Date createDateTime;
	private Date updateDateTime;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
