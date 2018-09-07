package com.kfzx.dao;

import com.kfzx.entity.Config;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public interface ConfigDao {

	Integer update(Config config);

	Config findById(Integer id);
}
