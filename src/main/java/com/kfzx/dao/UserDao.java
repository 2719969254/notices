package com.kfzx.dao;

import com.kfzx.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public interface UserDao {
	Integer add(User user);

	Integer update(User user);

	List<User> list(Map<String, Object> map);

	Integer getTotal(Map<String, Object> map);

	User findByName(String name);

	User findById(Integer id);

	Integer delete(Integer id);
}
