package com.kfzx.controller.houtai;

import com.kfzx.entity.Config;
import com.kfzx.service.ConfigService;
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
@RequestMapping("/houtai/config")
public class HouTaiConfigController {
	@Resource
	private ConfigService configService;

	/**
	 * /houtai/config/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "网站的配置");
		modelAndView.setViewName("/admin/page/config/config_manage");
		return modelAndView;
	}

	/**
	 * /houtai/config/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView modelAndView = new ModelAndView();
		Config config = configService.findById(Integer.parseInt(id));
		modelAndView.addObject("config", config);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/config/update?id=" + id);
		modelAndView.setViewName("/admin/page/config/add_or_update");
		return modelAndView;
	}
}