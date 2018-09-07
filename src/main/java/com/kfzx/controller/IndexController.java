package com.kfzx.controller;

import com.kfzx.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Controller
@RequestMapping("/")
public class IndexController {
	/**
	 * 显示主页
	 *
	 * @return ModelAndView
	 * @throws Exception 抛出一切异常
	 */
	@RequestMapping("/index")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/pc/index");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		String userAgent = req.getHeader("User-Agent");
		//判断AppleWebKit和 Firefox
		if (MyUtil.checkUserAgent(userAgent)) {
			mav.setViewName("/pc/login/login");
		} else {
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}

}
