package com.kfzx.service.impl;

import com.kfzx.dao.DownDao;
import com.kfzx.entity.Down;
import com.kfzx.service.DownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Service("downService")
public class DownServiceImpl implements DownService {

	@Resource
	private DownDao downDao;

	@Override
	public Integer add(Down down) {
		return downDao.add(down);
	}

	@Override
	public Integer update(Down down) {
		return downDao.update(down);
	}

	@Override
	public List<Down> list(Map<String, Object> map) {
		return downDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return downDao.getTotal(map);
	}

	@Override
	public Down findById(Integer id) {
		return downDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return downDao.delete(id);
	}

}
