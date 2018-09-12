package com.kfzx.controller.pc;

import com.kfzx.entity.Down;
import com.kfzx.entity.DownFenLei;
import com.kfzx.service.DownFenLeiService;
import com.kfzx.service.DownService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2018/9/12
 */
@Controller
@RequestMapping("/a/down")
public class PCDownController {

	@Resource
	private DownService downService;
	@Resource
	private DownFenLeiService downFenLeiService;


	/**
	 * fenleiId
	 * /a/down/list?id=1
	 */
	@RequestMapping("/list")
	public ModelAndView down(@RequestParam(value = "id", required = false) Integer id, HttpServletResponse res,
	                         HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();

		if(id==null){
			mav.addObject("title", "软件下载专区");
		}else{
			DownFenLei downFenLei=	downFenLeiService.findById(id);
			mav.addObject("title", downFenLei.getName()+"下载");
		}

		mav.addObject("downFenLeiId", id);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("isUse", 1);
		List<DownFenLei> downFenLeiList = downFenLeiService.list(map );
		mav.addObject("downFenLeiList", downFenLeiList);


		map.put("downFenLeiId", id);
		List<Down> downList = downService.list(map);
		mav.addObject("downList", downList);


		mav.setViewName("/pc/down/down_list");
		return mav;
	}



	/**
	 * /a/down/get?id=1
	 */
	@RequestMapping("/get")
	public ModelAndView get(@RequestParam(value = "id", required = false) Integer id, HttpServletResponse res,
	                        HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();

		Down down = downService.findById(id);
		mav.addObject("down", down);

		down.setClickHit(down.getClickHit()+1);
		downService.update(down);

		switch (down.getDisplay_mode()) {
			case 0:
				mav.setViewName("/pc/down/down_base");
				break;
			case 1:
				mav.setViewName("/pc/down/down_full");
				break;
			case 2:
				break;
		}
		return mav;
	}

}

