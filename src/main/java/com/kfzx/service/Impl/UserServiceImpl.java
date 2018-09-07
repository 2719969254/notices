package com.kfzx.service.Impl;

import com.kfzx.dao.UserDao;
import com.kfzx.entity.User;
import com.kfzx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public Integer add(User user) {
		return userDao.add(user);
	}

	@Override
	public Integer update(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> list(Map<String, Object> map) {
		return userDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return userDao.delete(id);
	}

}