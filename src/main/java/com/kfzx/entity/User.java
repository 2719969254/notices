package com.kfzx.entity;

import java.util.Date;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public class User {
	private Integer id;
	/**
	 * 帐号
	 */
	private String name;
	private String password;
	private Date createDateTime;
	private String menuIds;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 真实姓名
	 */
	private String trueName;


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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
}
