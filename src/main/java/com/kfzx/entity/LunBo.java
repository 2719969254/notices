package com.kfzx.entity;

import java.util.Date;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
public class LunBo {
	private Integer id;
	private String title;
	private String url;
	private String image_url;
	/**
	 * 是否使用 1   0 nouse
	 */

	private Integer isUse;
	/**
	 * 1站内打开       2 新窗口打开
	 */
	private Integer type;
	private Integer orderNo;
	/**
	 * 创建人id
	 */
	private Integer createUserId;
	/**
	 * 创建时间
	 */
	private Date createDateTime;
	/**
	 * 修改时间
	 */
	private Date updateDateTime;


	private User createUser;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
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

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
}
