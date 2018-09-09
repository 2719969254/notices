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
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "网站的配置");
		mav.setViewName("/admin/page/config/config_manage");
		return mav;
	}

	/**
	 * /houtai/config/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		Config config = configService.findById(Integer.parseInt(id));
		mav.addObject("config", config);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/config/update?id=" + id);
		mav.setViewName("/admin/page/config/add_or_update");
		return mav;
	}
}