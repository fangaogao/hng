package com.hng.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.AgriculClas;
import com.hng.service.IAgriculClasService;
import com.hng.util.ControllerUtil;


@Controller
@Scope("prototype")
public class IAgriculClasAction extends BaseAction {
	@Autowired
	private IAgriculClasService agriculService;
	
	public String result = SUCCESS;
	
	//获取一级分类列表
	public void getFirstClas() throws Exception {
		ControllerUtil.out(response,agriculService.getFirstClas());
	}
	//获取二级分类列表
	public void getSecondClas() throws Exception {
		Integer firstId = Integer.valueOf(request.getParameter("firstId"));
		ControllerUtil.out(response,agriculService.getSecondClas(new AgriculClas(firstId)));
	}
	//获取三级分类列表
	public void getThirdClas() throws Exception {
		Integer secondId = Integer.valueOf(request.getParameter("secondId"));
		ControllerUtil.out(response,agriculService.getThirdClas(new AgriculClas(secondId)));
	}
}
