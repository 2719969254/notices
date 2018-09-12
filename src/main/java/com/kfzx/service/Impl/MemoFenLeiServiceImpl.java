package com.kfzx.service.impl;

import com.kfzx.dao.MemoFenLeiDao;
import com.kfzx.entity.MemoFenLei;
import com.kfzx.service.MemoFenLeiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Service("memoFenLeiService")
public class MemoFenLeiServiceImpl implements MemoFenLeiService {

	@Resource
	private MemoFenLeiDao memoFenLeiDao;

	@Override
	public Integer add(MemoFenLei fenlei) {
		return memoFenLeiDao.add(fenlei);
	}

	@Override
	public Integer update(MemoFenLei fenlei) {
		return memoFenLeiDao.update(fenlei);
	}

	@Override
	public List<MemoFenLei> list(Map<String, Object> map) {
		return memoFenLeiDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return memoFenLeiDao.getTotal(map);
	}

	@Override
	public Integer delete(Integer id) {
		return memoFenLeiDao.delete(id);
	}

	@Override
	public MemoFenLei findById(Integer id) {
		return memoFenLeiDao.findById(id);
	}

}

