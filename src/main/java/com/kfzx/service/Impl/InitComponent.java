package com.kfzx.service.Impl;

import com.kfzx.entity.Config;
import com.kfzx.service.ConfigService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ConfigService configService=(ConfigService) applicationContext.getBean("configService");

		Config config = configService.findById(1);
		//保存到 缓存中
		application.setAttribute("config", config);

	}



	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitComponent.applicationContext =applicationContext;
	}

}

