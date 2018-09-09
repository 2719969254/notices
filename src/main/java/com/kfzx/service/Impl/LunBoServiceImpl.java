package com.kfzx.service.impl;

import com.kfzx.dao.LunBoDao;
import com.kfzx.entity.LunBo;
import com.kfzx.service.LunBoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
@Service("lunBoService")
public class LunBoServiceImpl implements LunBoService {
	@Resource
	private LunBoDao lunBoDao;

	@Override
	public Integer add(LunBo lunbo) {
		return lunBoDao.add(lunbo);
	}

	@Override
	public Integer update(LunBo lunbo) {
		return lunBoDao.update(lunbo);
	}

	@Override
	public List<LunBo> list(Map<String, Object> map) {
		return lunBoDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return lunBoDao.getTotal(map);
	}

	@Override
	public LunBo findById(Integer id) {
		return lunBoDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return lunBoDao.delete(id);
	}

	@Override
	public List<LunBo> index_list() {
		return lunBoDao.index_list();
	}
}
