package com.kfzx.service;

import com.kfzx.entity.LunBo;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
public interface LunBoService {
	/**
	 * 添加轮播图
	 *
	 * @param lunbo 轮播图对象
	 * @return Integer
	 */
	Integer add(LunBo lunbo);

	/**
	 * 更新轮播图
	 *
	 * @param lunbo 轮播图对象
	 * @return Integer
	 */
	Integer update(LunBo lunbo);

	/**
	 * @param map 查询集
	 * @return List<LunBo>
	 */
	List<LunBo> list(Map<String, Object> map);

	/**
	 * 获取总数
	 *
	 * @param map 查询集
	 * @return Integer
	 */
	Integer getTotal(Map<String, Object> map);

	/**
	 * 通过id查找
	 *
	 * @param id id
	 * @return LunBo
	 */
	LunBo findById(Integer id);

	/**
	 * 删除
	 *
	 * @param id id
	 * @return Integer
	 */
	Integer delete(Integer id);


	/**
	 * 首页 拿 轮播图片用的。
	 *
	 * @return List<LunBo>
	 */
	List<LunBo> index_list();
}
