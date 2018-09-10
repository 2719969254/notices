package com.kfzx.controller.houtai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 二维码后台
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
@Controller
@RequestMapping("/houtai/qrcode")
public class HouTaiQRcodeController {
	/**
	 * 生成二维码
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "二维码生成");
		mav.setViewName("/admin/page/qrcode/qrcode_manage");
		return mav;
	}
}
