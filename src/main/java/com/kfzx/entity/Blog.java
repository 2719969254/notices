package com.kfzx.entity;

import java.util.Date;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public class Blog {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 没有标签的内容
	 */
	private String contentNoTag;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 缩略图
	 */

	private String thumbnail_image;
	/**
	 * 搜索-关键字
	 */

	private String keywords;
	/**
	 * 搜索-描述
	 */
	private String description_;
	/**
	 * 查看次数
	 */

	private Integer clickHit;
	/**
	 * 回复次数
	 */
	private Integer replyHit;
	/**
	 * 展示模式  不同的模式 页面不同
	 */
	private Integer display_mode;

	private String url;
	/**
	 * 创建人id
	 */

	private Integer createUserId;
	/**
	 * 分类id
	 */
	private Integer blogFenLeiId;
	/**
	 * 是否显示
	 */

	private Integer isUse;
	/**
	 * 创建时间
	 */
	private Date createDateTime;
	/**
	 * 修改时间
	 */
	private Date updateDateTime;
	private User createUser;
	private BlogFenLei blogFenLei;

	public Integer getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getDisplay_mode() {
		return display_mode;
	}

	public void setDisplay_mode(Integer display_mode) {
		this.display_mode = display_mode;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbnail_image() {
		return thumbnail_image;
	}

	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentNoTag() {
		return contentNoTag;
	}

	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription_() {
		return description_;
	}

	public void setDescription_(String description_) {
		this.description_ = description_;
	}

	public Integer getClickHit() {
		return clickHit;
	}

	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}

	public Integer getReplyHit() {
		return replyHit;
	}

	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}


	public Integer getBlogFenLeiId() {
		return blogFenLeiId;
	}

	public void setBlogFenLeiId(Integer blogFenLeiId) {
		this.blogFenLeiId = blogFenLeiId;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
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

	public BlogFenLei getBlogFenLei() {
		return blogFenLei;
	}

	public void setBlogFenLei(BlogFenLei blogFenLei) {
		this.blogFenLei = blogFenLei;
	}
}
