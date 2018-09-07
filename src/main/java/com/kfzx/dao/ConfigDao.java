package com.kfzx.dao;

import com.kfzx.entity.Config;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public interface ConfigDao {
	/**
	 * 更新缓存
	 *
	 * @param config 缓存对象
	 * @return Integer
	 */
	Integer update(Config config);

	/**
	 * 通过id查找
	 *
	 * @param id id
	 * @return Config
	 */
	Config findById(Integer id);
}
