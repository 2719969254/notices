package com.kfzx.controller.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kfzx.entity.PageBean;
import com.kfzx.entity.User;
import com.kfzx.service.UserService;
import com.kfzx.util.CryptographyUtil;
import com.kfzx.util.ResponseUtil;
import com.kfzx.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/9
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	@Resource
	private UserService userService;

	/**
	 * 添加用户
	 */
	@RequestMapping("/add")
	public String add(User user, HttpServletResponse response) throws Exception {
		//md5  加盐   加密
		user.setPassword(CryptographyUtil.md5(user.getPassword(), "chenhao"));
		user.setCreateDateTime(new Date());

		int resultTotal = userService.add(user);

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
	 * /admin/user/update
	 *
	 * @return String
	 * @throws Exception 一切异常
	 */
	@RequestMapping("/update")
	public String update(User user, HttpServletResponse response) throws Exception {
		if (StringUtil.isNotEmpty(user.getPassword())) {
			user.setPassword(CryptographyUtil.md5(user.getPassword(), "chenhao"));
		}
		int resultTotal = userService.update(user);

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
	 * 修改 密码 在不退出登陆的情况下。可以多次修改密码。
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword, HttpServletResponse response) throws Exception {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		user.setPassword(CryptographyUtil.md5(newPassword, "tianzuo"));
		int resultTotal = userService.update(user);
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


	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
	                   @RequestParam(value = "limit", required = false) String limit,
	                   @RequestParam(value = "q", required = false) String q,
	                   @RequestParam(value = "date1", required = false) String date1,
	                   @RequestParam(value = "date2", required = false) String date2,
	                   HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(limit));
		Map<String, Object> map = new HashMap<>(1000);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("q", StringUtil.formatLike(q));
		map.put("date1", date1);
		map.put("date2", date2);

		List<User> list = userService.list(map);
		Integer total = userService.getTotal(map);
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
			userService.delete(Integer.parseInt(anIdsStr));
		}
		result.put("success", true);
		ResponseUtil.write(response, result.toString());
		return null;
	}

}

