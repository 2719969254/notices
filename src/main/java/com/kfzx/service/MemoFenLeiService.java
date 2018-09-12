package com.kfzx.service;

import com.kfzx.entity.MemoFenLei;

import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
public interface MemoFenLeiService {
	Integer add(MemoFenLei fenlei);

	Integer  update(MemoFenLei fenlei);

	List<MemoFenLei> list(Map<String,Object> map);

	Integer getTotal(Map<String,Object> map);

	Integer delete(Integer id);

	MemoFenLei findById(Integer id);

}
