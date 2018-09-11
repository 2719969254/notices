package com.kfzx.service.impl;

import com.kfzx.dao.LinkDao;
import com.kfzx.entity.Link;
import com.kfzx.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;

	@Override
	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

	@Override
	public Integer add(Link link) {
		int i = linkDao.add(link);
		Map<String, Object> map = new HashMap<>(1000);
		map.put("isUse", 1);
		List<Link> linkList = linkDao.list(map);
		//刷新缓存  友情 链接
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("linkList", linkList);
		return i;
	}

	@Override
	public Integer update(Link link) {
		int i = linkDao.update(link);
		Map<String, Object> map = new HashMap<>(1000);
		map.put("isUse", 1);
		List<Link> linkList = linkDao.list(map);
		//刷新缓存  友情 链接
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("linkList", linkList);

		return i;
	}


	@Override
	public Integer delete(Integer id) {
		int i = linkDao.delete(id);
		Map<String, Object> map = new HashMap<>(1000);
		map.put("isUse", 1);
		List<Link> linkList = linkDao.list(map);
		//刷新缓存  友情 链接
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		servletContext.setAttribute("linkList", linkList);
		return i;

	}

	@Override
	public Link findById(Integer id) {
		return linkDao.findById(id);
	}

}

