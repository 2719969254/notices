package com.kfzx.realm;

import com.kfzx.entity.User;
import com.kfzx.service.UserService;
import com.kfzx.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义Realm
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
public class MyRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;


	/**
	 * 为当前的登录的用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}


	/**
	 * 登录验证
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String loginType = (String) SecurityUtils.getSubject().getSession().getAttribute("login_type");
		switch (loginType) {
			case "wx_login":
				//我上面使用了openid
				String openid = (String) token.getPrincipal();
				if (openid != null) {
					return new SimpleAuthenticationInfo(openid, CryptographyUtil.md5(openid, "chenhao"), "xxx");
				}
				break;
			case "user_login":
				//我上面使用了name
				String name = (String) token.getPrincipal();
				User user = userService.findByName(name);
				if (user != null) {
					//SecurityUtils.getSubject().getSession().setAttribute("currentUser", user); //把当前用户信息存到session中
					return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), "xxx");
				}
				break;
			default:
		}
		return null;


	}
}
