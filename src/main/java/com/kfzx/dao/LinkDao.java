package com.kfzx.dao;

import com.kfzx.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * 友情链接Dao
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public interface LinkDao {
	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	List<Link> list(Map<String,Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	Integer getTotal(Map<String,Object> map);

	/**
	 * 添加友情链接信息
	 * @param
	 * @return
	 */
	Integer add(Link link);

	/**
	 * 修改友情链接信息
	 * @param link
	 * @return
	 */
	Integer update(Link link);

	/**
	 * 删除友情链接信息
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	Link findById(Integer id);
}
