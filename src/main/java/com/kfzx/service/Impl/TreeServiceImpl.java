package com.kfzx.service.Impl;

import com.kfzx.dao.TreeDao;
import com.kfzx.entity.Tree;
import com.kfzx.service.TreeService;
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
public class TreeServiceImpl implements TreeService {
	@Resource
	private TreeDao treeDao;

	@Override
	public Tree findById(Integer id) {
		return treeDao.findById(id);
	}

	@Override
	public List<Tree> getTreesByFatherOrIds(Map<String, Object> map) {
		return treeDao.getTreesByFatherOrIds(map);
	}
}
