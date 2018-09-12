package com.kfzx.controller.houtai;

import com.kfzx.entity.DownFenLei;
import com.kfzx.service.DownFenLeiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Controller
@RequestMapping("/houtai/down/fenlei")
public class HouTaiDownFenLeiController {
	@Resource
	private DownFenLeiService downFenLeiService;

	/**
	 *   /houtai/down/fenlei/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "用户管理");
		modelAndView.addObject("title", "用户管理");
		modelAndView.setViewName("/admin/page/down_fenlei/down_fenlei_manage");
		return modelAndView;
	}
	/**
	 * /houtai/down/fenlei/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("btn_text", "添加");
		modelAndView.addObject("save_url", "/admin/down/fenlei/add");
		modelAndView.setViewName("/admin/page/down_fenlei/add_or_update");
		return modelAndView;
	}

	/**
	 * /houtai/down/fenlei/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id) {
		ModelAndView modelAndView = new ModelAndView();
		DownFenLei fenlei = downFenLeiService.findById(Integer.parseInt(id));
		modelAndView.addObject("fenlei", fenlei);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/down/fenlei/update?id="+id);
		modelAndView.setViewName("/admin/page/down_fenlei/add_or_update");
		return modelAndView;
	}
}
