package com.kfzx.dao;

import com.kfzx.entity.BlogFenLei;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public interface BlogFenLeiDao {
	/**
	 *
	 * @param blogFenLei
	 * @return
	 */
	Integer add(BlogFenLei blogFenLei);

	/**
	 *
	 * @param blogFenLei
	 * @return
	 */
	Integer  update(BlogFenLei blogFenLei);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<BlogFenLei> list(Map<String,Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	Integer getTotal(Map<String,Object> map);

	/**
	 *
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);

	/**
	 *
	 * @param id
	 * @return
	 */
	BlogFenLei findById(Integer id);

}
