package com.kfzx.dao;

import com.kfzx.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public interface BlogDao {
	/**
	 * 添加文章
	 *
	 * @param blog 文章对象
	 * @return 是否成功
	 */
	Integer add(Blog blog);

	/**
	 * @param blog
	 * @return
	 */
	Integer update(Blog blog);

	/**
	 * @param map
	 * @return
	 */
	List<Blog> list(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Blog> list2(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	Integer getTotal(Map<String, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Blog findById(Integer id);

	/**
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);

}
