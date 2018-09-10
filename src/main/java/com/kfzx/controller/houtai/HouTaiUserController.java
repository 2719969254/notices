package com.kfzx.controller.houtai;

import com.kfzx.entity.User;
import com.kfzx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
@Controller
@RequestMapping("/houtai/user")
public class HouTaiUserController {

	@Resource
	private UserService userService;

	/**
	 * /houtai/user/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "用户管理");
		mav.addObject("title", "用户管理");
		mav.setViewName("/admin/page/user/user_manage");
		return mav;
	}


	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "添加");
		mav.addObject("save_url", "/admin/user/add");
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}


	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		User user = userService.findById(Integer.parseInt(id));
		mav.addObject("user", user);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/user/update?id=" + id);
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}


	@RequestMapping("/setPersm")
	public ModelAndView setPersm(@RequestParam(value = "id", required = false) String id) {

		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.setViewName("admin/page/user/set_persm");
		return mav;
	}

	@RequestMapping("/setPassword")
	public ModelAndView setPassword(@RequestParam(value = "id", required = false) String id) {
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("save_url", "/admin/user/update?id=" + id);
		mav.setViewName("admin/page/user/set_password");
		return mav;
	}
}