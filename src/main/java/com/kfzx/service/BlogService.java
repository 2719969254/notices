package com.kfzx.service;

import com.kfzx.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public interface BlogService {
	Integer add(Blog blog);

	Integer update(Blog blog);

	List<Blog> list(Map<String,Object> map);

	List<Blog> list2(Map<String,Object> map);

	Integer getTotal(Map<String,Object> map);

	Blog findById(Integer id);

	Integer delete(Integer id);

}
