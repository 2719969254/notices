package com.kfzx.dao;

import com.kfzx.entity.Memo;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
public interface MemoDao {
	Integer add(Memo memo);

	Integer update(Memo memo);

	List<Memo> list(Map<String,Object> map);

	Integer getTotal(Map<String,Object> map);

	Memo findById(Integer id);

	Integer delete(Integer id);

}

