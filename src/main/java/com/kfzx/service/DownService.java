package com.kfzx.service;

import com.kfzx.entity.Down;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
public interface DownService {
	/**
	 * 添加下载内容
	 *
	 * @param down 下载内容对象
	 * @return Integer
	 */
	Integer add(Down down);

	/**
	 * 更新下载内容
	 *
	 * @param down 下载内容对象
	 * @return Integer
	 */
	Integer update(Down down);

	/**
	 * 获取下载内容列表
	 *
	 * @param map 下载列表对象
	 * @return List<Down>
	 */
	List<Down> list(Map<String, Object> map);

	/**
	 * 获取下载内容总数
	 *
	 * @param map 下载列表对象
	 * @return Integer
	 */
	Integer getTotal(Map<String, Object> map);

	/**
	 * 通过id进行查找
	 *
	 * @param id id
	 * @return Down
	 */
	Down findById(Integer id);

	/**
	 * 通过id进行删除
	 *
	 * @param id id
	 * @return Integer
	 */
	Integer delete(Integer id);
}
