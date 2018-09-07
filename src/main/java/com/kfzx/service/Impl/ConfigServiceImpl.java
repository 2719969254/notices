package com.kfzx.service.impl;

import com.kfzx.dao.ConfigDao;
import com.kfzx.entity.Config;
import com.kfzx.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	@Resource
	private ConfigDao configDao;

	@Override
	public Integer update(Config config) {
		int i = configDao.update(config);
		config = configDao.findById(1);
		//刷新缓存
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("config", config);
		return i;
	}

	@Override
	public Config findById(Integer id) {
		return configDao.findById(id);
	}

}
