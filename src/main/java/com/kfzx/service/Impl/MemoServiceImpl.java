package com.kfzx.service.impl;

import com.kfzx.dao.MemoDao;
import com.kfzx.entity.Memo;
import com.kfzx.service.MemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */

@Service("memoService")
public class MemoServiceImpl implements MemoService {


	@Resource
	private MemoDao memoDao;

	@Override
	public Integer add(Memo memo) {
		return memoDao.add(memo);
	}

	@Override
	public Integer update(Memo memo) {
		return memoDao.update(memo);
	}

	@Override
	public List<Memo> list(Map<String, Object> map) {
		return memoDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return memoDao.getTotal(map);
	}

	@Override
	public Memo findById(Integer id) {
		return memoDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return memoDao.delete(id);
	}

}