package com.kfzx.controller.houtai;

import com.kfzx.entity.Blog;
import com.kfzx.entity.BlogFenLei;
import com.kfzx.service.BlogFenLeiService;
import com.kfzx.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Controller
@RequestMapping("/houtai/blog")
public class HouTaiBlogController {

	@Resource
	private BlogFenLeiService blogFenLeiService;
	@Resource
	private BlogService blogService;

	/**
	 * /houtai/blog/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView modelAndView = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>(1000);
		List<BlogFenLei> blogFenLeiList = blogFenLeiService.list(map);

		modelAndView.addObject("blogFenLeiList", blogFenLeiList);

		modelAndView.setViewName("/admin/page/blog/blog_manage");
		return modelAndView;
	}


	/**
	 * /houtai/blog/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("title", "添加文章");


		Map<String, Object> map = new HashMap<String, Object>();
		List<BlogFenLei> blogFenLeiList = blogFenLeiService.list(map);
		modelAndView.addObject("blogFenLeiList", blogFenLeiList);


		modelAndView.addObject("btn_text", "添加");
		modelAndView.addObject("save_url", "/admin/blog/add");
		modelAndView.setViewName("/admin/page/blog/add_or_update");
		return modelAndView;
	}


	/**
	 * /houtai/blog/edit
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
		ModelAndView modelAndView = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>(1000);
		List<BlogFenLei> blogFenLeiList = blogFenLeiService.list(map);
		modelAndView.addObject("blogFenLeiList", blogFenLeiList);
		Blog blog = blogService.findById(Integer.parseInt(id));
		modelAndView.addObject("title", "修改文章-" + blog.getTitle());

		modelAndView.addObject("isEdit", true);

		modelAndView.addObject("blog", blog);
		modelAndView.addObject("btn_text", "修改");
		modelAndView.addObject("save_url", "/admin/blog/update?id=" + id);
		modelAndView.setViewName("/admin/page/blog/add_or_update");
		return modelAndView;

	}

}
