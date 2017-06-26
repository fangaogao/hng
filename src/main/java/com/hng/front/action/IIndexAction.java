package com.hng.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.AgriculClas;
import com.hng.service.IAgriculClasService;

@Controller
@Scope("prototype")
public class IIndexAction extends BaseAction {
	
	@Autowired
	private IAgriculClasService agriculClasService;
	
	public String result = SUCCESS;
	
	//获取主页分类信息
	public String index() throws Exception {
		List<AgriculClas> threeClas = agriculClasService.getThreeClas();
		request.setAttribute("threeClas", threeClas);
		return result;
	}
	
}
