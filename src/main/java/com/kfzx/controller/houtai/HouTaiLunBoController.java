package com.kfzx.controller.houtai;

import com.kfzx.entity.LunBo;
import com.kfzx.service.LunBoService;
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
@RequestMapping("/houtai/lunbo")
public class HouTaiLunBoController {
	@Resource
	private LunBoService lunBoService;


	/**
	 * /houtai/lunbo/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/lunbo/lunbo_manage");
		return mav;
	}

	/**
	 * /houtai/lunbo/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "添加");
		mav.addObject("save_url", "/admin/lunbo/add");
		mav.setViewName("/admin/page/lunbo/add_or_update");
		return mav;
	}

	/**
	 * /houtai/lunbo/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		LunBo lunbo = lunBoService.findById(Integer.parseInt(id));
		mav.addObject("lunbo", lunbo);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/lunbo/update?id=" + id);
		mav.setViewName("/admin/page/lunbo/add_or_update");
		return mav;
	}
}
