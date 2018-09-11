package com.kfzx.controller.houtai;

import com.kfzx.entity.BlogFenLei;
import com.kfzx.service.BlogFenLeiService;
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
@RequestMapping("/houtai/blog/fenlei")
public class HouTaiBlogFenLeiController {

	@Resource
	private BlogFenLeiService blogFenLeiService;

	/**
	 *   /houtai/blog/fenlei/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/blog_fenlei/blog_fenlei_manage");
		return mav;
	}
	/**
	 * /houtai/blog/fenlei/add
	 */
	@RequestMapping("/add")
	public ModelAndView add()  {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("btn_text", "添加");
		modelAndView.addObject("save_url", "/admin/blog/fenlei/add");
		modelAndView.setViewName("/admin/page/blog_fenlei/add_or_update");
		return modelAndView;
	}
	/**
	 * /houtai/blog/fenlei/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id) {
		ModelAndView modelAndView = new ModelAndView();
		BlogFenLei fenLei = blogFenLeiService.findById(Integer.parseInt(id));
		modelAndView.addObject("fenlei", fenLei);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/blog/fenlei/update?id="+id);
		modelAndView.setViewName("/admin/page/blog_fenlei/add_or_update");
		return modelAndView;
	}
}

