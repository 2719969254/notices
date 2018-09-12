package com.kfzx.controller.houtai;

import com.kfzx.entity.Memo;
import com.kfzx.entity.MemoFenLei;
import com.kfzx.service.MemoFenLeiService;
import com.kfzx.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Controller
@RequestMapping("/houtai/memo")
public class HouTai_Memo_Controller {

	@Resource
	private MemoService memoService;

	@Resource
	private MemoFenLeiService memoFenLeiService;
	/**
	 *   /houtai/mome/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isUse", 1);
		List<MemoFenLei> memoFenLeiList = memoFenLeiService.list(map );
		mav.addObject("memoFenLeiList", memoFenLeiList);

		mav.setViewName("/admin/page/memo/memo_manage");
		return mav;
	}


	/**
	 * /houtai/mome/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isUse", 1);
		List<MemoFenLei> memoFenLeiList = memoFenLeiService.list(map );
		mav.addObject("memoFenLeiList", memoFenLeiList);

		mav.addObject("btn_text", "添加");
		mav.addObject("save_url", "/admin/memo/add");
		mav.setViewName("/admin/page/memo/add_or_update");

		return mav;
	}


	/**
	 * /houtai/mome/edit?id=3
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			, HttpServletResponse response
			, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isUse", 1);
		List<MemoFenLei> memoFenLeiList = memoFenLeiService.list(map );
		mav.addObject("memoFenLeiList", memoFenLeiList);

		Memo memo = memoService.findById(Integer.parseInt(id));
		mav.addObject("memo", memo);
		mav.addObject("btn_text", "修改");
		mav.addObject("save_url", "/admin/memo/update?id="+id);
		mav.setViewName("/admin/page/memo/add_or_update");

		return mav;
	}




}

