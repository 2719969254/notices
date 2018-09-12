package com.kfzx.controller.houtai;

import com.kfzx.entity.MemoFenLei;
import com.kfzx.service.MemoFenLeiService;
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
@RequestMapping("/houtai/memo/fenlei")
public class HouTai_Memo_FenLei_Controller {

	@Resource
	private MemoFenLeiService memoFenLeiService;


	/**
	 *   /houtai/mome/fenlei/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/memo_fenlei/memo_fenlei_manage");
		return mav;
	}


	/**
	 * /houtai/mome/fenlei/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "添加");
		mav.addObject("save_url", "/admin/memo/fenlei/add");
		mav.setViewName("/admin/page/memo_fenlei/add_or_update");
		return mav;
	}


	/**
	 * /houtai/mome/fenlei/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			, HttpServletResponse response
			, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemoFenLei fenlei = memoFenLeiService.findById(Integer.parseInt(id));
		mav.addObject("fenlei", fenlei);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/memo/fenlei/update?id="+id);
		mav.setViewName("/admin/page/memo_fenlei/add_or_update");
		return mav;
	}




}

