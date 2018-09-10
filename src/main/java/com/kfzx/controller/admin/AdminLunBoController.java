package com.kfzx.controller.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kfzx.entity.LunBo;
import com.kfzx.entity.PageBean;
import com.kfzx.entity.User;
import com.kfzx.service.LunBoService;
import com.kfzx.util.DateUtil;
import com.kfzx.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
@RequestMapping("/admin/lunbo")
public class AdminLunBoController {

	@Resource
	private LunBoService lunBoService;

	/**
	 * /admin/lunbo/add
	 */
	@RequestMapping("/add")
	public String add(LunBo lunbo, HttpServletResponse response) throws Exception {
		lunbo.setCreateDateTime(new Date());
		lunbo.setUpdateDateTime(new Date());
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		lunbo.setCreateUserId(currentUser.getId());

		int resultTotal = lunBoService.add(lunbo);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
			result.put("msg", "添加成功");
			result.put("btn_disable", true);
		} else {
			result.put("success", false);
			result.put("msg", "添加失败");
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}


	/**
	 * /admin/lunbo/update
	 */
	@RequestMapping("/update")
	public String update(LunBo lunbo, HttpServletResponse response) throws Exception {
		lunbo.setUpdateDateTime(new Date());
		int resultTotal = lunBoService.update(lunbo);
		JSONObject result = new JSONObject();

		if (resultTotal > 0) {
			result.put("success", true);
			result.put("msg", "修改成功");
			result.put("btn_disable", false);
		} else {
			result.put("success", false);
			result.put("msg", "修改失败");
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}


	/**
	 * /admin/lunbo/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
	                   @RequestParam(value = "limit", required = false) String limit,
	                   @RequestParam(value = "isUse", required = false) String isUse,
	                   HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(limit));

		Map<String, Object> map = new HashMap<>(1000);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("isUse", isUse);


		List<LunBo> list = lunBoService.list(map);
		Integer total = lunBoService.getTotal(map);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();

		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");

		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}

	/**
	 * /admin/lunbo/delete
	 *
	 * @param ids id
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();

		for (String anIdsStr : idsStr) {
			lunBoService.delete(Integer.parseInt(anIdsStr));
		}
		result.put("success", true);
		ResponseUtil.write(response, result.toString());
		return null;
	}


	/**
	 * /admin/lunbo/add_image_url
	 */
	@RequestMapping("/add_image_url")
	public String addImageUrl(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam("file") MultipartFile file,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		JSONObject result = new JSONObject();

		if (!file.isEmpty()) {
			String webPath = request.getServletContext().getRealPath("");
			String filePath = "/static/upload_image/lunbo/";
			String imageName = DateUtil.formatDate(new Date(), "yyyy-MM-dd-hh-mm-ss-SSS") + ".jpg";

			file.transferTo(new File(webPath + filePath + imageName));
			result.put("success", true);
			result.put("path", filePath + imageName);
		}
		ResponseUtil.write(response, result.toString());
		return null;
	}

}

