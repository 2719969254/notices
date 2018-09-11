package com.kfzx.service.impl;

import com.kfzx.dao.BlogFenLeiDao;
import com.kfzx.entity.BlogFenLei;
import com.kfzx.service.BlogFenLeiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Service("blogFenLeiService")
public class BlogFenLeiServiceImpl implements BlogFenLeiService {


	@Resource
	private BlogFenLeiDao blogFenLeiDao;

	@Override
	public Integer add(BlogFenLei blogFenLei) {
		return blogFenLeiDao.add(blogFenLei);
	}

	@Override
	public Integer update(BlogFenLei blogFenLei) {
		return blogFenLeiDao.update(blogFenLei);
	}

	@Override
	public List<BlogFenLei> list(Map<String, Object> map) {
		return blogFenLeiDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return blogFenLeiDao.getTotal(map);
	}

	@Override
	public Integer delete(Integer id) {
		return blogFenLeiDao.delete(id);
	}

	@Override
	public BlogFenLei findById(Integer id) {
		return blogFenLeiDao.findById(id);
	}
}
