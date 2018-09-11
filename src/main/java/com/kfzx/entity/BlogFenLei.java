package com.kfzx.entity;

import java.util.Date;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public class BlogFenLei {
	private Integer id;
	private String name;
	private Integer isUse;
	/**
	 * 排序号
	 */
	private Integer orderNo;
	/**
	 * 这个模块出现在哪里。 1基础模块
	 */
	private Integer pos;

	private Date createDateTime;
	private Date updateDateTime;
	private String remark;



	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
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
