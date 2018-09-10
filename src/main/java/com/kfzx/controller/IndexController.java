package com.kfzx.controller;

import com.kfzx.service.PublicService;
import com.kfzx.util.*;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Resource
	private PublicService publicService;

	/**
	 * 显示主页
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
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

	/**
	 * 后台主页
	 */
	@RequestMapping("/admin/main")
	public ModelAndView adminMain(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		publicService.addLeftMenu(mav);
		System.out.println(MyUtil.getRemoteAddress(req));

		String userAgent = req.getHeader("User-Agent");
		if (MyUtil.checkUserAgent(userAgent)) {
			mav.setViewName("/admin/main");
		} else {
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}

	/**
	 * /qrcode/create
	 *
	 * @param content 将内容转成二维码返回
	 */
	@RequestMapping("/qrcode/create")
	public String qrcodeCreate(@RequestParam(value = "content", required = false) String content,
	                           HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 生成二维码QRCode图片
		BufferedImage bufImg = QRcodeUtil.qRCodeCommon(content, "jpg", QRcodeUtil.getSize(content));

		// 保存到电脑
		String fileName = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
		String webPath = request.getSession().getServletContext().getRealPath("");
		String filePath = "/static/upload_image/qrcode/";

		webPath = webPath + filePath;
		FileUtil.makeDirs(webPath);
		try {
			// 把img存到服务器上面。 返回地址给对面
			ImageIO.write(bufImg, "jpg", new File(webPath + fileName + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		result.put("path", filePath + fileName + ".jpg");
		result.put("msg", "请将二维码图片保存到手机上面,或者电脑 ");
		ResponseUtil.write(response, result.toString());
		return null;
	}
}
