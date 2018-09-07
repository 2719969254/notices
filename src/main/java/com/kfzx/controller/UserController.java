package com.kfzx.controller;

import com.kfzx.entity.User;
import com.kfzx.service.UserService;
import com.kfzx.util.CryptographyUtil;
import com.kfzx.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录注销controller
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 电脑登陆
	 * @param user
	 * @param response
	 * @param request
	 * @param attr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletResponse response, HttpServletRequest request
			, RedirectAttributes attr) throws Exception {
		JSONObject result = new JSONObject();

		Subject subject = SecurityUtils.getSubject();

		SecurityUtils.getSubject().getSession().setAttribute("login_type", "user_login");

		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), CryptographyUtil.md5(user.getPassword(), "chenhao"));
		try {
			// 登录验证
			subject.login(token);
			//如果登陆成功 就不会报错  报错就是登陆失败了
			user = userService.findByName(user.getName());
			//把当前用户信息存到session中
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
			//return "redirect:/admin/main";
			result.put("success", true);
			result.put("msg", "登陆成功");
			ResponseUtil.write(response, result.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "帐号或密码错误");
			ResponseUtil.write(response, result.toString());
			return null;
		}
	}

}
