package com.kfzx.service.impl;

import com.kfzx.entity.Tree;
import com.kfzx.entity.User;
import com.kfzx.service.PublicService;
import com.kfzx.service.TreeService;
import com.kfzx.service.UserService;
import com.kfzx.util.MyUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/7
 */
@Service("publicService")
public class PublicServiceImpl implements PublicService {

	@Resource
	private TreeService treeService;
	@Resource
	private UserService userService;


	@Override
	public void addLeftMenu(ModelAndView mav) {

		mav.addObject("leftPage", "/admin/common/left_menu.jsp");

		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		currentUser = userService.findById(currentUser.getId());

		Map<String, Object> map = new HashMap<String, Object>();
		String menuIds = currentUser.getMenuIds();
		if(menuIds==null){
			menuIds = "";
		}
		List<Integer> ids = MyUtil.Str_ids_To_ListInteger_ids(menuIds);
		map.put("father", -1);
		map.put("ids", ids);

		if(ids.size()>0){
		}else{
			mav.addObject("treeList", null);
		}

		try {
			List<Tree> treeList = getTreesByParentId(map);
			mav.addObject("treeList", treeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 拿菜单
	 * List<Tree> 大菜。   ---setChildren  子菜单
	 */
	public List<Tree> getTreesByParentId(Map<String,Object> map) throws Exception {
		//String parentId,String ids  = map
		List<Tree> list = treeService.getTreesByFatherOrIds(map);
		/*二维码生成
		网站配置管理
		轮播图片管理.~~~*/


		/*辅助功能  id  6
		文章  13
		软件下载  16
		备忘录模块   19  */

		/*select * from t_tree WHERE father= 6
				and id in ( 6,,61010,61015,13,131007,131020,16,161001,161005,19,191001,191002,991005  )
				 ORDER BY id ASC
		 */
		for(Tree tree : list){
			//如果 是复选框  可以在这里判断
			//tree.setChecked(true);
			if("open".equals(tree.getState())){
				continue;
			}else{
				map.put("father", tree.getId()+"");//更换father  不换ids继续查
				tree.setChildren(getTreesByParentId(map));
			}
		}
		return list;
	}


}

