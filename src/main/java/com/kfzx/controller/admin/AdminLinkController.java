package com.kfzx.controller.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kfzx.entity.Link;
import com.kfzx.entity.PageBean;
import com.kfzx.service.LinkService;
import com.kfzx.util.ResponseUtil;
import com.kfzx.util.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/11
 */
@Controller
@RequestMapping("/admin/link")
public class AdminLinkController {
	@Resource
	private LinkService linkService;

	/**
	 * /admin/link/add
	 */
	@RequestMapping("/add")
	public String add(Link link, HttpServletResponse response, HttpServletRequest request) throws Exception {
		link.setCreateDateTime(new Date());
		link.setUpdateDateTime(new Date());

		int resultTotal = linkService.add(link);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
			result.put("msg", "添加成功");
		} else {
			result.put("success", false);
			result.put("msg", "添加失败");
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}

	/**
	 * /admin/link/update
	 */
	@RequestMapping("/update")
	public String update(Link link, HttpServletResponse response, HttpServletRequest request) throws Exception {
		link.setUpdateDateTime(new Date());
		int resultTotal = linkService.update(link);
		JSONObject result = new JSONObject();

		if (resultTotal > 0) {
			result.put("success", true);
			result.put("msg", "添加成功");
		} else {
			result.put("success", false);
			result.put("msg", "添加失败");
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}


	/**
	 * /admin/link/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
	                   @RequestParam(value = "limit", required = false) String rows,
	                   @RequestParam(value = "q", required = false) String q,
	                   HttpServletResponse response,
	                   HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("q", StringUtil.formatLike(q));

		List<Link> list = linkService.list(map);
		Integer total = linkService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();

		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}


	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();

		for (String anIdsStr : idsStr) {
			linkService.delete(Integer.parseInt(anIdsStr));
		}
		result.put("success", true);
		ResponseUtil.write(response, result.toString());
		return null;
	}
}
