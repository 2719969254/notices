package com.kfzx.controller.houtai;

import com.kfzx.entity.Link;
import com.kfzx.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Controller
@RequestMapping("/houtai/link")
public class HouTaiLinkController {
	@Resource
	private LinkService linkService;

	/**
	 * 展示友情链接controller
	 * /houtai/link/manage
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/page/link/link_manage");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("btn_text", "添加");
		modelAndView.addObject("save_url", "/admin/link/add");
		modelAndView.setViewName("/admin/page/link/add_or_update");
		return modelAndView;
	}

	/**
	 * /houtai/link/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView modelAndView = new ModelAndView();
		Link link = linkService.findById(Integer.parseInt(id));
		modelAndView.addObject("link", link);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/link/update?id=" + id);
		modelAndView.setViewName("/admin/page/link/add_or_update");
		return modelAndView;
	}
}
