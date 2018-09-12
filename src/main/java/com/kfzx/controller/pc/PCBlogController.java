package com.kfzx.controller.pc;

import com.kfzx.entity.Blog;
import com.kfzx.service.BlogService;
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
@RequestMapping("/a/blog")
public class PCBlogController {

	@Resource
	private BlogService blogService;

	/**
	 * /a/blog/get?id=1
	 */
	@RequestMapping("/get")
	public ModelAndView get(@RequestParam(value = "id", required = false) Integer id, HttpServletResponse res,
	                        HttpServletRequest req){
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id);
		modelAndView.addObject("blog", blog);

		blog.setClickHit(blog.getClickHit() + 1);
		blogService.update(blog);

		switch (blog.getDisplay_mode()) {
			case 0:
				modelAndView.setViewName("/pc/blog/blog_base");
				break;
			case 1:
				modelAndView.setViewName("/pc/blog/blog_full");
				break;
			case 2:
				modelAndView.setViewName("/pc/blog/wap_blog");
				break;
			case 3:
				modelAndView.setViewName("/pc/blog/blog_base_no_nav");
				break;
			case 4:
				modelAndView.setViewName("/pc/blog/blog_full_no_nav");
				break;
		}
		return modelAndView;
	}

}
