package com.kfzx.service.impl;

import com.kfzx.dao.BlogDao;
import com.kfzx.entity.Blog;
import com.kfzx.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {


	@Resource
	private BlogDao blogDao;

	@Override
	public Integer add(Blog blog) {
		return blogDao.add(blog);
	}

	@Override
	public Integer update(Blog blog) {
		return blogDao.update(blog);
	}

	@Override
	public List<Blog> list(Map<String, Object> map) {
		return blogDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}

	@Override
	public Blog findById(Integer id) {
		return blogDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return blogDao.delete(id);
	}

	@Override
	public List<Blog> list2(Map<String, Object> map) {
		return blogDao.list2(map);
	}

}

