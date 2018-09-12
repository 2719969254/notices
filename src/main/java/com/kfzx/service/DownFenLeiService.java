package com.kfzx.service;

import com.kfzx.entity.DownFenLei;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
public interface DownFenLeiService {
	/**
	 * 添加下载分类
	 *
	 * @param downFenLei 分类对象
	 * @return Integer
	 */
	Integer add(DownFenLei downFenLei);

	/**
	 * 更新先下载分类信息
	 *
	 * @param downFenLei 分类对象
	 * @return Integer
	 */
	Integer update(DownFenLei downFenLei);

	/**
	 * 获取下载分类信息
	 *
	 * @param map 下载分类对象
	 * @return List<DownFenLeiService>
	 */
	List<DownFenLei> list(Map<String, Object> map);

	/**
	 * 获取下载分类总数
	 *
	 * @param map 下载分类对象
	 * @return Integer
	 */
	Integer getTotal(Map<String, Object> map);

	/**
	 * 通过id删除分类
	 *
	 * @param id id
	 * @return Integer
	 */
	Integer delete(Integer id);

	/**
	 * 通过id查找分类
	 *
	 * @param id id
	 * @return DownFenLeiService
	 */
	DownFenLei findById(Integer id);
}
