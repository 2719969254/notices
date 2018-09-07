package com.kfzx.service;

import com.kfzx.entity.Config;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public interface ConfigService {
	Integer update(Config config);

	Config findById(Integer id);

}
