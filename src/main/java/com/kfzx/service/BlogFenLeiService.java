package com.kfzx.service;

import com.kfzx.entity.BlogFenLei;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
public interface BlogFenLeiService {
	Integer add(BlogFenLei blogFenLei);

	Integer  update(BlogFenLei blogFenLei);

	List<BlogFenLei> list(Map<String,Object> map);

	Integer getTotal(Map<String,Object> map);

	Integer delete(Integer id);

	BlogFenLei findById(Integer id);

}
