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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "用户管理");
		modelAndView.addObject("title", "用户管理");
		modelAndView.setViewName("/admin/page/user/user_manage");
		return modelAndView;
	}


	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("btn_text", "添加");
		modelAndView.addObject("save_url", "/admin/user/add");
		modelAndView.setViewName("/admin/page/user/add_or_update");
		return modelAndView;
	}


	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findById(Integer.parseInt(id));
		modelAndView.addObject("user", user);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/user/update?id=" + id);
		modelAndView.setViewName("/admin/page/user/add_or_update");
		return modelAndView;
	}


	@RequestMapping("/setPersm")
	public ModelAndView setPersm(@RequestParam(value = "id", required = false) String id) {

		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userId", id);
		modelAndView.setViewName("admin/page/user/set_persm");
		return modelAndView;
	}

	@RequestMapping("/setPassword")
	public ModelAndView setPassword(@RequestParam(value = "id", required = false) String id) {
		//如果id有值就是 更新 如果没有值  就是添加
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userId", id);
		modelAndView.addObject("save_url", "/admin/user/update?id=" + id);
		modelAndView.setViewName("admin/page/user/set_password");
		return modelAndView;
	}
}