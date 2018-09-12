package com.kfzx.service.impl;

import com.kfzx.dao.DownFenLeiDao;
import com.kfzx.entity.DownFenLei;
import com.kfzx.service.DownFenLeiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Service("downFenLeiService")
public class DownFenLeiServiceImpl implements DownFenLeiService {
	@Resource
	private DownFenLeiDao downFenLeiDao;

	@Override
	public Integer add(DownFenLei downFenLei) {
		return downFenLeiDao.add(downFenLei);
	}

	@Override
	public Integer update(DownFenLei downFenLei) {
		return downFenLeiDao.update(downFenLei);
	}

	@Override
	public List<DownFenLei> list(Map<String, Object> map) {
		return downFenLeiDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return downFenLeiDao.getTotal(map);
	}

	@Override
	public Integer delete(Integer id) {
		return downFenLeiDao.delete(id);
	}

	@Override
	public DownFenLei findById(Integer id) {
		return downFenLeiDao.findById(id);
	}
}
