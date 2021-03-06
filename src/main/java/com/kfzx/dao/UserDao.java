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
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return Integer
	 */
	Integer add(User user);

	/**
	 * 更新用户
	 * @param user 用户对象
	 * @return Integer
	 */

	Integer update(User user);

	/**
	 * 获取用户集合
	 * @param map 查询条件
	 * @return List
	 */
	List<User> list(Map<String, Object> map);

	/**
	 * 获取符合条件用户总数
	 * @param map 查询条件
	 * @return Integer
	 */
	Integer getTotal(Map<String, Object> map);

	/**
	 * 通过姓名查找
	 * @param name 姓名
	 * @return User
	 */
	User findByName(String name);

	/**
	 * 通过id查找
	 * @param id id
	 * @return User
	 */
	User findById(Integer id);

	/**
	 * 通过id删除用户
	 * @param id id
	 * @return Integer
	 */
	Integer delete(Integer id);
}
