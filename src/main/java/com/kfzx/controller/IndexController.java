package com.kfzx.controller;

import com.kfzx.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @param request  请求
	 * @param response 相应
	 * @return ModelAndView
	 * @throws Exception 抛出一切异常
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/pc/index");
		return mav;
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletResponse  res,HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();

		String UserAgent = req.getHeader("User-Agent");
		//判断AppleWebKit 和  Firefox

		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}

}
