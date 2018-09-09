package com.kfzx.dao;

import com.kfzx.entity.LunBo;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
public interface LunBoDao {
	Integer add(LunBo lunbo);

	Integer update(LunBo lunbo);


	List<LunBo> list(Map<String,Object> map);
	Integer getTotal(Map<String,Object> map);


	LunBo findById(Integer id);

	Integer delete(Integer id);


	/**
	 * 首页 拿 轮播图片用的。
	 *
	 * @return
	 */
	List<LunBo> index_list();
}
