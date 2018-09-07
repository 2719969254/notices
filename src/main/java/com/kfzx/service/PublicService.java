package com.kfzx.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public interface PublicService {
	/**
	 *  添加后台路径左面菜单
	 * @param  mav 添加mav.addObject("leftPage", "/admin/common/left_menu.jsp"); 以及添加leftmenu 的内容
	 * @param mav
	 */
	void addLeftMenu(ModelAndView mav);
}
